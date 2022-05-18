package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class PhotographerModel {
    private static final Logger LOGGER = LogManager.getLogger(PhotographerModel.class);
    private int id;
    private String name;
    private List<CameraModel> cameras;

    public PhotographerModel() {
    }

    public PhotographerModel(String name, List<CameraModel> cameras) {
        this.name = name;
        this.setCameras(cameras);
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

    public List<CameraModel> getCameras() {
        return cameras;
    }

    public void setCameras(List<CameraModel> cameras) {
        this.cameras = cameras;
    }

    @Override
    public String toString() {
        return "[" + "id: " + getId() + " Name: " + getName() + "; Camera: " + getCameras() + "]";
    }
}
