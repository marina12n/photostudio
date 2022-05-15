package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventModel {
    private static final Logger LOGGER = LogManager.getLogger(EventModel.class);
    private int id;
    private String name;
    private String location;

    public EventModel() {
        this.setName("Wedding");
        this.setLocation("Forest");
    }
    public EventModel(String name, String location) {
        this.setName(name);
        this.setLocation(location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}