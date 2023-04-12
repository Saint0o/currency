package com.trasulov.currency.service;

import com.trasulov.currency.csvEntity.DailyCurrency;
import com.trasulov.currency.dao.CurrencyDao;
import com.trasulov.currency.dao.RateDateDao;
import com.trasulov.currency.repositories.RateDateRepository;
import com.trasulov.currency.service.client.CbnClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Stream;

import static com.trasulov.currency.helpers.DateHelper.toInstant;

@Service
@Slf4j
public class IntegrationService {

    @Autowired
    private CbnClient cbnClient;

    @Autowired
    private RateDateService rateDateService;

    @Autowired
    private RateService rateService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private RateDateRepository rateDateRepository;

    @Scheduled(cron = "${rate.integration-cron}")
    public void integrationByCron() {
        log.info("НАЧИНАЮ ИНТЕГРАЦИЮ");
        LocalDate actualDate = LocalDate.now();

        integrateCurrencyByDate(actualDate);
    }

    private void integrateCurrencyByDate(LocalDate localDate) {

        List<DailyCurrency> dailyCurrencyList = cbnClient.getPeriodData(localDate);

        RateDateDao rateDateDao = rateDateService.saveRateDateIfNotExist(localDate);

        dailyCurrencyList.forEach(dailyCurrency -> {
            CurrencyDao currencyDao = currencyService.saveCurrencyIfNotExist(dailyCurrency);
            rateService.saveRateIfNotExist(rateDateDao, currencyDao, dailyCurrency);
        });
    }

    public void integrateIfNotExistByPeriod(LocalDate from, LocalDate to) {
        List<RateDateDao> rateDates =  rateDateRepository.findAllByDatePeriod(toInstant(from), toInstant(to));

        List<LocalDate> dates = rateDates.stream().map(RateDateDao::getDate).toList();

        Stream.iterate(from, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(from, to) + 1)
                .filter(date -> !dates.contains(date)).forEach(this::integrateCurrencyByDate);
    }


}
