package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentTypeModel {
    private static final Logger LOGGER = LogManager.getLogger(PaymentTypeModel.class);
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentTypeModel() {
        this.name = "Cash";
    }

    public PaymentTypeModel(String name) {
        this.setName(name);
    }
}