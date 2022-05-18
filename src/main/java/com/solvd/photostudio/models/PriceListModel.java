package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PriceListModel {
    private static final Logger LOGGER = LogManager.getLogger(PriceListModel.class);
    private int id;
    private String name;
    private String price;
    private List<EventModel> events;

    public PriceListModel() {
    }

    public PriceListModel(String name, String price, String event, List<EventModel> events) {
        this.name = name;
        this.price = price;
        this.setEvents(events);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "[id: " + getId() + " Name: " + getName() + "; Price: " + getPrice() + " Event: " + getEvents() + "]";
    }
}