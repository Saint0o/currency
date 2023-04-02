package com.trasulov.currency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trasulov.currency.dao.CurrencyDao;


public interface CurrencyRepository extends JpaRepository<CurrencyDao, Integer> {
    
}
