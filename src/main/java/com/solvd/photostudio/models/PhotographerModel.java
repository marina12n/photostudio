package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhotographerModel {
    private static final Logger LOGGER = LogManager.getLogger(PhotographerModel.class);
    private int id;
    private String name;
    private String camera;

    public PhotographerModel() {
        this.setName("Bob");
        this.setCamera("Canon");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
