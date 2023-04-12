package com.trasulov.currency.controllers;

import com.trasulov.currency.dto.StatisticDto;
import com.trasulov.currency.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/v1/statistic")
@CrossOrigin
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping()
    public StatisticDto getStatistic(@RequestParam LocalDate from, @RequestParam LocalDate to, @RequestParam String code) {
        return statisticService.getStatisticByPeriod(from, to, code);
    }
}
