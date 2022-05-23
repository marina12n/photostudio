package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LocationModel {
    private static final Logger LOGGER = LogManager.getLogger(LocationModel.class);
    private int id;
    private String name;
    private List<EventModel> events;

    public LocationModel() {
    }

    public LocationModel(String name) {
        this.setName(name);
    }

    public LocationModel(String name, List<EventModel> events) {
        this.setName(name);
        this.setEvents(events);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "[id: " + getId() + " Name: " + getName() + "Events: " + getEvents() +  "]";
    }
}