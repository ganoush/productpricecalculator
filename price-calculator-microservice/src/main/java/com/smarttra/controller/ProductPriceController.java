package com.smarttra.controller;

import com.smarttra.dto.ProductPrice;
import com.smarttra.services.ProductQuotesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
@RestController
@RequestMapping(value="/product")
public class ProductPriceController {
    private static final Logger log = LoggerFactory.getLogger(ProductPriceController.class);

    @Autowired
    ProductQuotesService productQuotesService;

    /**
     * For the given content this endpoint retrieves the product price for the given product quote
     * @param ISIN
     * @param value
     * @param volatility
     * @return
     */
    @RequestMapping(value = "/productPrice/{ISIN}/{value}/{volatility}",  method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<ProductPrice> getProductPrice(@PathVariable(value = "ISIN") String ISIN,
                                                        @PathVariable(value = "value") double value, @PathVariable(value = "volatility") double volatility){
        log.info("Request to retrieve product price for " + ISIN);
        ProductPrice productPrice = productQuotesService.getProductPrice(ISIN, value, volatility);
        log.info("Product Price returned " + productPrice);
        ResponseEntity<ProductPrice> response;
        if (Optional.ofNullable(productPrice).isPresent()){
            response = new ResponseEntity<>(productPrice, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}
