package com.trasulov.currency.service.client;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.exceptions.CsvException;
import com.trasulov.currency.csvEntity.DailyCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
@Slf4j
public class CbnClient {

    @Value("${rate.integration-url}")
    private String integrationUrl;

    @Autowired
    private RestTemplate restTemplate;


    public Map<LocalDate, List<DailyCurrency>> getPeriodData(LocalDate from, LocalDate to) throws IOException, CsvException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Map<LocalDate, List<DailyCurrency>> dailyCurrencyList = new HashMap<>();

        Stream.iterate(from, date -> date.plusDays(1))
                .limit(ChronoUnit.DAYS.between(from, to) + 1)
                .forEach(date -> {
                    List<DailyCurrency> response;

                    try {
                        response = getPeriodData(date);
                    } catch (IOException | CsvException e) {
                        throw new RuntimeException(e);
                    }

                    dailyCurrencyList.put(date, response);

                });

        return dailyCurrencyList;
    }

    public List<DailyCurrency> getPeriodData(LocalDate date) throws IOException, CsvException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        ResponseEntity<String> response = restTemplate.getForEntity(String.format("%s?date=%s", integrationUrl, date.format(formatter)), String.class);

        return parseCsvToDailyCurrency(response.getBody());
    }

    private List<DailyCurrency> parseCsvToDailyCurrency(String csv) {
        StringReader stringReader = new StringReader(csv);
        CSVReader reader = new CSVReader(stringReader, '|');

        ColumnPositionMappingStrategy<DailyCurrency> beanStrategy = new ColumnPositionMappingStrategy<>();
        beanStrategy.setType(DailyCurrency.class);
        beanStrategy.setColumnMapping("Country", "Currency", "Amount", "Code", "Rate");

        CsvToBean<DailyCurrency> csvToBean = new CsvToBean<>();

        List<DailyCurrency> dailyCurrencyList = csvToBean.parse(beanStrategy, reader);

        dailyCurrencyList.remove(0);
        dailyCurrencyList.remove(0);

        return dailyCurrencyList;
    }

}