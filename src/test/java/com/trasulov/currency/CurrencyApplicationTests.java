package com.trasulov.currency;

import com.opencsv.exceptions.CsvException;
import com.trasulov.currency.repositories.RateDateRepository;
import com.trasulov.currency.repositories.RateRepository;
import com.trasulov.currency.service.IntegrationService;
import com.trasulov.currency.service.client.CbnClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;

@SpringBootTest
class CurrencyApplicationTests {

	@Autowired
	private CbnClient cbnClient;

	@Autowired
	private RateDateRepository rateDateRepository;

	@Autowired
	private IntegrationService integrationService;

	@Test
	void contextLoads() throws IOException, CsvException {
		cbnClient.getPeriodData(null, null);
	}

	@Test
	void test() {
		integrationService.integrationByCron();
	}




}
