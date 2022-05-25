package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceListModel {
    private static final Logger LOGGER = LogManager.getLogger(PriceListModel.class);
    private int id;
    private String name;
    private String price;
    private EventModel eventModel;

    public PriceListModel() {
    }

    public PriceListModel(String name, String price, String event, EventModel eventModel) {
        this.setName(name);
        this.setPrice(price);
        this.setEventModel(eventModel);
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

    public EventModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
    }

    public String toString() {
        return "PriceList: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() + '\'' +
                ", event=" + getEventModel() +
                '}';
    }
}