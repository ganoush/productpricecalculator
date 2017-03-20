package com.smarttra.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList(String ISIN, double value, double volatility) {
        URI uri = URI.create("http://localhost:8060/product/productPrice/"+ISIN+"/"+value+"/"+volatility);
        // Or simply invoke directly any other service within same module. It is assumed the service is present in another module
        return this.restTemplate.getForObject(uri, String.class);
    }

    /**
     * Method that returns some cached value/default value
     * @param ISIN
     * @param value
     * @param volatility
     * @return
     */
    public String reliable(String ISIN, double value, double volatility) {
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        Date date = new Date();
        return "{\"price\":"+value+",\"date\":"+date+"}";
    }
}
