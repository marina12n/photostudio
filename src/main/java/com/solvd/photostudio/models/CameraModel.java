package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CameraModel {
    private static final Logger LOGGER = LogManager.getLogger(CameraModel.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CameraModel() {
        this.name = "Sony";
    }

    public CameraModel(String name) {
        this.setName(name);
    }
}
