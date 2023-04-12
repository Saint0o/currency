package com.trasulov.currency.repositories;

import com.trasulov.currency.dao.RateDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RateRepository extends JpaRepository<RateDao, Integer> {
    Optional<RateDao> findByCurrencyIdAndRateDateId(Integer currencyId, Integer rateDateId);
}
