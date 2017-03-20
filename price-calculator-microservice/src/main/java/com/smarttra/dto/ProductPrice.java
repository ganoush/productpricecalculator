package com.smarttra.dto;

/**
 * Created by ganeshnagarajan on 3/19/17.
 */
public class ProductPrice {
    private double price;
    private String date;

    public ProductPrice(){
    }

    public ProductPrice(double price, String date){
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString(){
        return "Price : " + this.price + ", date : " + this.date;
    }
}
