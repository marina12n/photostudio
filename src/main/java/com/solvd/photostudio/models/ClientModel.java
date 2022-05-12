package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientModel.class);
    private String name;
    private String phoneNumber;
    private String dateOfRegistration;

    public ClientModel() {
        this.setName("John");
        this.setPhoneNumber("+380971234567");
        this.setDateOfRegistration("10/04/2022");
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

    @Override
    public String toString() {
        return "[Name: " + name + "; Phone: " + phoneNumber + " Date: " + dateOfRegistration + "]";
    }
}