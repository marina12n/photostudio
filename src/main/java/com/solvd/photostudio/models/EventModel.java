package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class EventModel {
    private static final Logger LOGGER = LogManager.getLogger(EventModel.class);
    private long id;
    private String name;
    private LocationModel locationModel;
    private List<BillingModel> billingModels;
    private List<ClientHasEventModel> clientHasEventModels;

    public EventModel() {
    }

    public EventModel(String name) {
        this.setName(name);
    }

    public EventModel(String name, LocationModel locationModel, List<BillingModel> billingModels, List<ClientHasEventModel> clientHasEventModels) {
        this.setName(name);
        this.setLocationModel(locationModel);
        this.setBillingModels(billingModels);
        this.setClientHasEventModels(clientHasEventModels);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return (int) id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public List<BillingModel> getBillingModels() {
        return billingModels;
    }

    public void setBillingModels(List<BillingModel> billingModels) {
        this.billingModels = billingModels;
    }

    public List<ClientHasEventModel> getClientHasEventModels() {
        return clientHasEventModels;
    }

    public void setClientHasEventModels(List<ClientHasEventModel> clientHasEventModels) {
        this.clientHasEventModels = clientHasEventModels;
    }

    @Override
    public String toString() {
        return "Event: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", location=" + getLocationModel() + '\'' +
                ", billing=" + getBillingModels() + '\'' +
                ", clientHasEvent=" + getClientHasEventModels() +
                '}';
    }
}