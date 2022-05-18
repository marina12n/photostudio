package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LocationModel {
    private static final Logger LOGGER = LogManager.getLogger(LocationModel.class);
    private int id;
    private String name;

    public LocationModel() {
        this.name = "Studio";
    }

    public LocationModel(String name) {
        this.setName(name);
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

    @Override
    public String toString() {
        return "[id: " + id + " Name: " + name + "]";
    }
}