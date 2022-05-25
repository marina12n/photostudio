package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ClientModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientModel.class);
    private int id;
    private String name;
    private String phoneNumber;
    private String dateOfRegistration;
    private List<BillingModel> billingModels;
    private List<ScheduleModel> scheduleModels;
    private List<ClientHasEventModel> clientHasEventModels;

    public ClientModel() {
    }

    public ClientModel(String name, String phoneNumber, String dateOfRegistration, List<BillingModel> billingModels, List<ScheduleModel> scheduleModels, List<ClientHasEventModel> clientHasEventModels) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
        this.setDateOfRegistration(dateOfRegistration);
        this.setBillingModels(billingModels);
        this.setScheduleModels(scheduleModels);
        this.setClientHasEventModels(clientHasEventModels);
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public List<BillingModel> getBillingModels() {
        return billingModels;
    }

    public void setBillingModels(List<BillingModel> billingModels) {
        this.billingModels = billingModels;
    }

    public List<ScheduleModel> getScheduleModels() {
        return scheduleModels;
    }

    public void setScheduleModels(List<ScheduleModel> scheduleModels) {
        this.scheduleModels = scheduleModels;
    }

    public List<ClientHasEventModel> getClientHasEventModels() {
        return clientHasEventModels;
    }

    public void setClientHasEventModels(List<ClientHasEventModel> clientHasEventModels) {
        this.clientHasEventModels = clientHasEventModels;
    }

    @Override
    public String toString() {
        return "Client: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", phone=" + getPhoneNumber() + '\'' +
                ", date=" + getDateOfRegistration() + '\'' +
                ", billings=" + getBillingModels() + '\'' +
                ", schedules=" + getScheduleModels() + '\'' +
                ", clientHasEvents=" + getClientHasEventModels() +
                '}';
    }
}