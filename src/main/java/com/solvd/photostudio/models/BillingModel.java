package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BillingModel {
    private static final Logger LOGGER = LogManager.getLogger(BillingModel.class);
    private String event;
    private String client;
    private String paymentType;

    public BillingModel() {
        this.setEvent("Wedding");
        this.setClient("John");
        this.setPaymentType("crypto");
    }

    public BillingModel(String event, String client, String paymentType) {
        this.setEvent(event);
        this.setClient(client);
        this.setPaymentType(paymentType);
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
