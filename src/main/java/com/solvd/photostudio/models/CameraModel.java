package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CameraModel {
    private static final Logger LOGGER = LogManager.getLogger(CameraModel.class);
    private int id;
    private String name;

    public CameraModel() {
        this.setName("Sony");
    }

    public CameraModel(String name){
        this.name = name;
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
        return "[id: " + getId() +  " Name: " + getName() + "]";
    }
}