package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdministratorModel {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorModel.class);
    private int id;
    private String name;

    public AdministratorModel() {
    }

    public AdministratorModel(String name) {
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
        return "Administrator: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}