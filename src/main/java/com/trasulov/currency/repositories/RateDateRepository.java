package com.trasulov.currency.repositories;

import com.trasulov.currency.dao.RateDateDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateDateRepository extends JpaRepository<RateDateDao, Long> {
}
