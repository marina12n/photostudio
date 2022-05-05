package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScheduleModel {
    private static final Logger LOGGER = LogManager.getLogger(ScheduleModel.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScheduleModel() {
        this.name = "Standard";
    }

    public ScheduleModel(String name) {
        this.setName(name);
    }
}
