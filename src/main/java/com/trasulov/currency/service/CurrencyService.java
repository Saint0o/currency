package com.trasulov.currency.service;

import com.trasulov.currency.csvEntity.DailyCurrency;
import com.trasulov.currency.dao.CurrencyDao;
import com.trasulov.currency.dao.RateDateDao;
import com.trasulov.currency.repositories.CurrencyRepository;
import com.trasulov.currency.service.client.CbnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public CurrencyDao saveCurrencyIfNotExist(DailyCurrency dailyCurrency) {
        Optional<CurrencyDao> currencyDao = currencyRepository.findByCode(dailyCurrency.getCode());

        return currencyDao.orElseGet(() -> currencyRepository.save(new CurrencyDao(dailyCurrency)));
    }

    

    
}
