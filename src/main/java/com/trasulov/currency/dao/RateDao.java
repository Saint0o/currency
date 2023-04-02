package com.trasulov.currency.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rate")
@NoArgsConstructor
@Data
public class RateDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;

    private Integer amount;

    private Integer rateDateId;

    private Integer currencyId;
}
