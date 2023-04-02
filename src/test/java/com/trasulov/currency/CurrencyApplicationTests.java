package com.trasulov.currency;

import com.opencsv.exceptions.CsvException;
import com.trasulov.currency.service.client.CbnClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class CurrencyApplicationTests {

	@Autowired
	private CbnClient cbnClient;

	@Test
	void contextLoads() throws IOException, CsvException {
		cbnClient.getPeriodData(null, null);
	}

}
