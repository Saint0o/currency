package com.trasulov.currency.controllers;

import com.trasulov.currency.dto.IntegrationPeriodDto;
import com.trasulov.currency.service.client.CbnClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/integration")
public class IntegrationController {

    CbnClient cbnClient;

    @Autowired
    IntegrationController(CbnClient cbnClient) {
        this.cbnClient = cbnClient;
    }

    @PostMapping
    public ResponseEntity<?> periodIntegration(@RequestBody IntegrationPeriodDto period) {
        return new ResponseEntity<>(period, HttpStatus.OK);
    }
}
