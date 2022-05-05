package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceListModel {
    private static final Logger LOGGER = LogManager.getLogger(PriceListModel.class);
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PriceListModel() {
        this.name = "Bob";
    }

    public PriceListModel(String name, int price) {
        this.setName(name);
        this.setPrice(price);
    }
}