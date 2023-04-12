package com.trasulov.currency.service;

import com.trasulov.currency.dao.RateDateDao;
import com.trasulov.currency.dto.StatisticDto;
import com.trasulov.currency.repositories.RateDateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.trasulov.currency.helpers.DateHelper.toInstant;

@Service
@Slf4j
public class StatisticService {

    @Autowired
    private IntegrationService integrationService;

    @Autowired
    private RateService rateService;

    public StatisticDto getStatisticByPeriod(LocalDate from, LocalDate to, String code) {
        integrationService.integrateIfNotExistByPeriod(from, to);

        return rateService.getRateStatistic(toInstant(from), toInstant(to), code);
    }


}
