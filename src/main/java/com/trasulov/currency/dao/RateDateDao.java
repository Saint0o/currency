package com.trasulov.currency.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "rate_date")
@NoArgsConstructor
@Data
public class RateDateDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Boolean isExist;

    private Date date;
}
