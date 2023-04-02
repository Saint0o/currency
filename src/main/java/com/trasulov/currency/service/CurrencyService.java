package com.trasulov.currency.service;

import com.trasulov.currency.service.client.CbnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Autowired
    private CbnClient cbnClient;

    
}
