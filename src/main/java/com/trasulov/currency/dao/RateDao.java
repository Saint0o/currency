package com.trasulov.currency.dao;

import com.trasulov.currency.csvEntity.DailyCurrency;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rate")
@NoArgsConstructor
@Data
public class RateDao {
    public RateDao(DailyCurrency dailyCurrency, Integer rateDateId, Integer currencyId) {
        this.rate = Double.valueOf(dailyCurrency.getRate());
        this.amount = Integer.valueOf(dailyCurrency.getAmount());
        this.rateForOne = rate / amount;
        this.rateDateId = rateDateId;
        this.currencyId = currencyId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double rate;

    private Double rateForOne;

    private Integer amount;

    private Integer rateDateId;

    private Integer currencyId;
}
