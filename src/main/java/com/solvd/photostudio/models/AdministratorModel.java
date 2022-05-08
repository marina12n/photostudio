package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdministratorModel {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorModel.class);
    private String name;

    public AdministratorModel() {
        this.name = "Alice";
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
}