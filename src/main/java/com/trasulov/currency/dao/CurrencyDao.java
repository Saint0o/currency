package com.trasulov.currency.dao;

import com.trasulov.currency.csvEntity.DailyCurrency;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currency")
@NoArgsConstructor
@Data
public class CurrencyDao {

    public CurrencyDao (DailyCurrency dailyCurrency) {
        this.country = dailyCurrency.getCountry();
        this.code = dailyCurrency.getCode();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String country;

    private String code;
}
