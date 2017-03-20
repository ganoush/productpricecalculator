package com.smarttra.services;

import com.smarttra.dto.ProductPrice;
import com.smarttra.dto.ProductQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
@Service
public class ProductQuotesService {

    private static final Logger logger = LoggerFactory.getLogger(ProductQuotesService.class);

    private Random random = new Random();
    private Map<ProductQuote, ProductPrice> productQuotes = new HashMap<>();

    /**
     * Add initial product quotes for Google, Microsoft, Qualcom
     */
    @PostConstruct
    public void initialize() {
        productQuotes.put(new ProductQuote("GOOG", 123.32, 12.0), new ProductPrice(25.32, getDate(2016,11,21)));
        productQuotes.put(new ProductQuote("MSFT", 243.33, 6.1), new ProductPrice(54.43, getDate(2016,4,15)));
        productQuotes.put(new ProductQuote("QLCM", 83.22, 3.54), new ProductPrice(76.83, getDate(2016,9,05)));
    }

    /*Method to fetch the product quotes*/
    public ProductPrice getProductPrice(String ISIN, double value, double volatility) {
        // To simulate  timeout & circuit breaker behaviour, this method will randomly introduce a delay
        ProductQuote productQuote = new ProductQuote(ISIN, value, volatility);
        int rand = random.nextInt(3);
        if (rand == 0) { // Simulate a timeout
            logger.info("Delaying for 25 ms");
            delay(25);
        } else if (rand == 1) {  // Simulate a failure
            logger.info("Delaying for 2000 ms");
            delay(2000);
        }
        ProductPrice price = productQuotes.get(productQuote);
        return price;
    }

    /*Method to introduce delay*/
    private void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    private String getDate(int year, int month, int day){
        // local time zone. Else use UTC/JODA or get date for specific timezone
        Calendar calendar = new GregorianCalendar(year,month,day);
        return calendar.getTime().toString();
    }
}
