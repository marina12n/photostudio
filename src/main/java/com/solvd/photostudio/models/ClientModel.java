package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientModel.class);
    private String name;
    private int phone_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
    public ClientModel() {
        this.name = "John";
        this.phone_number=123;
    }

    public ClientModel(String name, int phone_number) {
        this.setName(name);
        this.setPhone_number(phone_number);
    }
}
