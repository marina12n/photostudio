package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdministratorModel {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorModel.class);
    private int id;
    private String name;
    private ScheduleModel scheduleModel;

    public AdministratorModel() {
    }

    public AdministratorModel(String name, ScheduleModel scheduleModel) {
        this.setName(name);
        this.setScheduleModel(scheduleModel);
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

    public ScheduleModel getScheduleModel() {
        return scheduleModel;
    }

    public void setScheduleModel(ScheduleModel scheduleModel) {
        this.scheduleModel = scheduleModel;
    }

    @Override
    public String toString() {
        return "[id: " + getId() + "Name: " + getName() + "Schedule:" + getScheduleModel() + "]";
    }

}