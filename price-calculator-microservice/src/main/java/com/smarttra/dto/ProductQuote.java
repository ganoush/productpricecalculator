package com.smarttra.dto;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
public class ProductQuote {
    private String ISIN;
    private double value;
    private double volatility;

    public ProductQuote(){
    }

    public ProductQuote(String ISIN, double value, double volatility){
        this.ISIN = ISIN;
        this.value = value;
        this.volatility = volatility;
    }

    public String getISIN() {
        return ISIN;
    }

    public void setISIN(String ISIN) {
        this.ISIN = ISIN;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = false;
        if (obj instanceof ProductQuote) {
            ProductQuote that = (ProductQuote) obj;
            if (that!= null && this.ISIN.equalsIgnoreCase(that.getISIN()) && this.volatility == that.getVolatility() && this.value == that.getValue()) {
                equals = true;
            }
        }
        return equals;
    }

    @Override
    public int hashCode(){
        int hash = 17;
        hash = 31 * hash + ISIN.hashCode();
        hash = (int) (31 * hash + volatility);
        hash = (int) (31 * hash + value);
        return hash;
    }
}
