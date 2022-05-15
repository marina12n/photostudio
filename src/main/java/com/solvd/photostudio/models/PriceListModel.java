package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceListModel {
    private static final Logger LOGGER = LogManager.getLogger(PriceListModel.class);
    private int id;
    private String name;
    private String price;
    private String event;

    public PriceListModel() {
        this.setName("Bob");
        this.setPrice("100$");
        this.setEvent("Walk");
    }

    public PriceListModel(String name, String price, String event) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "[ID: " + id + " Name: " + name + "; Price: " + price + " Event: " + event + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}