package com.trasulov.currency.repositories;

import com.trasulov.currency.dao.RateDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface RateRepository extends JpaRepository<RateDao, Integer> {
    Optional<RateDao> findByCurrencyIdAndRateDateId(Integer currencyId, Integer rateDateId);

    @Query(value = "select avg(rate_for_one) from rate as r left join rate_date as rd on r.rate_date_id = rd.id  where rd.\"date\"  >= :date_from and rd.\"date\" <= :date_to and r.currency_id = :currency_id", nativeQuery = true)
    Optional<Double> findAvgRate(@Param("date_from") Instant from, @Param("date_to") Instant to, @Param("currency_id") Integer currencyId);

    @Query(value = "select min(rate_for_one) from rate as r left join rate_date as rd on r.rate_date_id = rd.id  where rd.\"date\"  >= :date_from and rd.\"date\" <= :date_to and r.currency_id = :currency_id", nativeQuery = true)
    Optional<Double> findMinRate(@Param("date_from") Instant from, @Param("date_to") Instant to, @Param("currency_id") Integer currencyId);

    @Query(value = "select max(rate_for_one) from rate as r left join rate_date as rd on r.rate_date_id = rd.id  where rd.\"date\"  >= :date_from and rd.\"date\" <= :date_to and r.currency_id = :currency_id", nativeQuery = true)
    Optional<Double> findMaxRate(@Param("date_from") Instant from, @Param("date_to") Instant to, @Param("currency_id") Integer currencyId);
}
