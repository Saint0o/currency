package com.trasulov.currency.dto;

import lombok.Data;

@Data
public class CurrencyDto {
    private double minRate;

    private double maxRate;

    private double avgRate;
}
