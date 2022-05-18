package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ScheduleModel {
    private static final Logger LOGGER = LogManager.getLogger(ScheduleModel.class);
    private int id;
    private String name;
    private List<PhotographerModel> photographers;
    private List<ClientModel> clients;
    private AdministratorModel administratorModel;

    public ScheduleModel() {
    }

    public ScheduleModel(String name, List<PhotographerModel> photographers, List<ClientModel> clients, AdministratorModel administratorModel) {
        this.setName(name);
        this.setPhotographers(photographers);
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

    public List<PhotographerModel> getPhotographers() {
        return photographers;
    }

    public void setPhotographers(List<PhotographerModel> photographers) {
        this.photographers = photographers;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientModel> clients) {
        this.clients = clients;
    }

    public AdministratorModel getAdministratorModel() {
        return administratorModel;
    }

    public void setAdministratorModel(AdministratorModel administratorModel) {
        this.administratorModel = administratorModel;
    }

    @Override
    public String toString() {
        return "[id: " + getId() + "Name: " + getName() + " Photographer: " + getPhotographers() + " Client: " + getClients() +  " Admin: " + getAdministratorModel() + "]";
    }
}
