package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class EventModel {
    private static final Logger LOGGER = LogManager.getLogger(EventModel.class);
    private long id;
    private String name;
    private LocationModel locationModel;

    public EventModel() {
    }

    public EventModel(String name) {
        this.setName(name);
    }

    public EventModel(String name, LocationModel locationModel) {
        this.setName(name);
        this.setLocationModel(locationModel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public LocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    @Override
    public String toString() {
        return "[" + "Id: " + getId() + "Name: " + getName() + "Location: " + getLocationModel() + "]";
    }
}