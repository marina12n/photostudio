package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ScheduleModel {
    private static final Logger LOGGER = LogManager.getLogger(ScheduleModel.class);
    private int id;
    private String name;
    private PhotographerModel photographerModel;
    private ClientModel clientModel;
    private AdministratorModel administratorModel;

    public ScheduleModel() {
    }

    public ScheduleModel(String name, PhotographerModel photographerModel, ClientModel clientModel, AdministratorModel administratorModel) {
        this.setName(name);
        this.setPhotographerModel(photographerModel);
        this.setClientModel(clientModel);
        this.setAdministratorModel(administratorModel);
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

    public PhotographerModel getPhotographerModel() {
        return photographerModel;
    }

    public void setPhotographerModel(PhotographerModel photographerModel) {
        this.photographerModel = photographerModel;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public AdministratorModel getAdministratorModel() {
        return administratorModel;
    }

    public void setAdministratorModel(AdministratorModel administratorModel) {
        this.administratorModel = administratorModel;
    }

    @Override
    public String toString() {
        return "Schedule: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", photographer_id=" + getPhotographerModel() +
                ", client_id=" + getClientModel() +
                ", administrator_id=" + getAdministratorModel() +
                '}';
    }
}