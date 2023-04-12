package com.trasulov.currency.service;

import com.trasulov.currency.csvEntity.DailyCurrency;
import com.trasulov.currency.dao.CurrencyDao;
import com.trasulov.currency.dao.RateDao;
import com.trasulov.currency.dao.RateDateDao;
import com.trasulov.currency.repositories.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    public RateDao saveRateIfNotExist(RateDateDao rateDateDao, CurrencyDao currencyDao, DailyCurrency dailyCurrency) {
        Optional<RateDao> rateDao = rateRepository.findByCurrencyIdAndRateDateId(currencyDao.getId(), rateDateDao.getId());

        return rateDao.orElseGet(() -> rateRepository.save(new RateDao(dailyCurrency, rateDateDao.getId(), currencyDao.getId())));
    }
}
