package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ScheduleModel {
    private static final Logger LOGGER = LogManager.getLogger(ScheduleModel.class);
    private int id;
    private String name;
    private int photographer_id;
    private int client_id;
    private int administrator_id;

    public ScheduleModel() {
    }

    public ScheduleModel(String name, int photographer_id, int client_id, int administrator_id) {
        this.setName(name);
        this.setPhotographer_id(photographer_id);
        this.setClient_id(client_id);
        this.setAdministrator_id(administrator_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPhotographer_id() {
        return photographer_id;
    }

    public void setPhotographer_id(int photographer_id) {
        this.photographer_id = photographer_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    @Override
    public String toString() {
        return "Schedule: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", photographer_id=" + getPhotographer_id() +
                ", client_id=" + getClient_id() +
                ", administrator_id=" + getAdministrator_id() +
                '}';
    }
}
