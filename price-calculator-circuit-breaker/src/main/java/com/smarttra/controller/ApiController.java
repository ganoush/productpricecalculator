package com.smarttra.controller;

import com.smarttra.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
@EnableCircuitBreaker
@RestController
@RequestMapping(value="/api")
public class ApiController {
    @Autowired
    private ApiService apiService;


    @RequestMapping(value = "/priceQuote/{ISIN}/{value}/{volatility}")
    public String toRead(@PathVariable(value = "ISIN") String ISIN,
                               @PathVariable(value = "value") double value, @PathVariable(value = "volatility") double volatility) {
        return apiService.readingList(ISIN,value,volatility);
    }
}
