package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhotographerModel {
    private static final Logger LOGGER = LogManager.getLogger(PhotographerModel.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotographerModel() {
        this.name = "Bob";
    }

    public PhotographerModel(String name) {
        this.setName(name);
    }
}
