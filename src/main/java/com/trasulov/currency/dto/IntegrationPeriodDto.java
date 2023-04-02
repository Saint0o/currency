package com.trasulov.currency.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class IntegrationPeriodDto {
    private LocalDate from;

    private LocalDate to;
}
