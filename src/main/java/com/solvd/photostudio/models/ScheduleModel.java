package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScheduleModel {
    private static final Logger LOGGER = LogManager.getLogger(ScheduleModel.class);
    private String name;
    private String photographer;
    private String client;
    private String administrator;

    public ScheduleModel() {
        this.setName("Standard");
        this.setPhotographer("Valera");
        this.setClient("Angelina");
        this.setAdministrator("Anna");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }
}
