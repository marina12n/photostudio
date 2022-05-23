package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CameraModel {
    private static final Logger LOGGER = LogManager.getLogger(CameraModel.class);
    private int id;
    private String name;
    private List<PhotographerModel> photographers;

    public CameraModel() {
    }

    public CameraModel(String name){
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

    public List<PhotographerModel> getPhotographers() {
        return photographers;
    }

    public void setPhotographers(List<PhotographerModel> photographers) {
        this.photographers = photographers;
    }

    @Override
    public String toString() {
        return "Camera: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", photographers=" + getPhotographers() +
                '}';
    }
}