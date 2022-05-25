package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaymentTypeModel {
    private static final Logger LOGGER = LogManager.getLogger(PaymentTypeModel.class);
    private int id;
    private String name;
    private BillingModel billingModel;

    public PaymentTypeModel() {
    }

    public PaymentTypeModel(String name, BillingModel billingModel) {
        this.setName(name);
        this.setBillingModel(billingModel);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BillingModel getBillingModel() {
        return billingModel;
    }

    public void setBillingModel(BillingModel billingModel) {
        this.billingModel = billingModel;
    }

    @Override
    public String toString() {
        return "PaymentType: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", billing=" + getBillingModel() +
                '}';
    }
}
