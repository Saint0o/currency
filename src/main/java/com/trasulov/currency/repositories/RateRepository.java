package com.trasulov.currency.repositories;

import com.trasulov.currency.dao.RateDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<RateDao, Integer> {
}
