package com.trasulov.currency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatisticDto {
    private Double minRate;

    private Double maxRate;

    private Double avgRate;
}
