package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class EventModel {
    private static final Logger LOGGER = LogManager.getLogger(EventModel.class);
    private int id;
    private String name;
    private List<LocationModel> locations;

    public EventModel() {
    }

    public EventModel(String name, List<LocationModel> locations) {
        this.setName(name);
        this.setLocations(locations);
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

    public List<LocationModel> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationModel> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "[" + "Id: " + getId() + "Name: " + getName() + "  Location: " + getLocations() + "]";
    }
}