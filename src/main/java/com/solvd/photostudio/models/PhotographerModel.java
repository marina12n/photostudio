package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class PhotographerModel {
    private static final Logger LOGGER = LogManager.getLogger(PhotographerModel.class);
    private int id;
    private String name;
    private int camera_id;

    public PhotographerModel() {
    }

    public PhotographerModel(String name, int camera_id) {
        this.setName(name);
        this.setCamera_id(camera_id);
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


    public int getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(int camera_id) {
        this.camera_id = camera_id;
    }

    @Override
    public String toString() {
        return "[" + "id: " + getId() + " Name: " + getName() + "]";
    }
}
