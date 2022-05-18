package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentTypeModel {
    private static final Logger LOGGER = LogManager.getLogger(PaymentTypeModel.class);
    private int id;
    private String name;

    public PaymentTypeModel() {
    }

    public PaymentTypeModel(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[id: " + getId() + "Name: " + name + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
