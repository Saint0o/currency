package com.trasulov.currency.repositories;

import com.trasulov.currency.dao.RateDateDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RateDateRepository extends JpaRepository<RateDateDao, Long> {
    Optional<RateDateDao> findByDate(LocalDate date);

    @Query(value = "SELECT id FROM rate_date WHERE date >= :min_date AND date <= :max_date", nativeQuery = true)
    List<Integer> findAllIdByDateMaxAndDateMin(@Param("min_date") Instant minDate, @Param("max_date") Instant maxDate);


}
