package com.trasulov.currency.service;

import com.trasulov.currency.dao.RateDateDao;
import com.trasulov.currency.repositories.RateDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class RateDateService {

    @Autowired
    private RateDateRepository rateDateRepository;

    public RateDateDao saveRateDateIfNotExist(LocalDate date) {

        Optional<RateDateDao> rateDateDao = rateDateRepository.findByDate(date);

        return rateDateDao.orElseGet(() -> rateDateRepository.save(new RateDateDao(date)));
    }


}
