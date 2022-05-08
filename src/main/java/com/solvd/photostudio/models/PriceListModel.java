package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceListModel {
    private static final Logger LOGGER = LogManager.getLogger(PriceListModel.class);
    private String name;
    private int price;
    private String event;

    public PriceListModel() {
        this.setName("Bob");
        this.setPrice(100);
        this.setEvent("Walk");
    }

    public PriceListModel(String name, int price, String event) {
        this.setName(name);
        this.setPrice(price);
        this.setEvent(event);
    }

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

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}