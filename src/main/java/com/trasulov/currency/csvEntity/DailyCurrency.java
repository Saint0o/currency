package com.trasulov.currency.csvEntity;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class DailyCurrency {

    @CsvBindByPosition(position = 0)
    private String country;

    @CsvBindByPosition(position = 1)
    private String currency;

    @CsvBindByPosition(position = 2)
    private String amount;

    @CsvBindByPosition(position = 3)
    private String code;

    @CsvBindByPosition(position = 4)
    private String rate;
}
