package com.trasulov.currency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trasulov.currency.dao.CurrencyDao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface CurrencyRepository extends JpaRepository<CurrencyDao, Integer> {
    Optional<CurrencyDao> findByCode(String code);

    List<CurrencyDao> findAllByIdIn(Collection<Integer> id);
}
