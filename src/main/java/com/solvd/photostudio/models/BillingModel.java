package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BillingModel {
    private static final Logger LOGGER = LogManager.getLogger(BillingModel.class);
    private int id;
    private EventModel eventModel;
    private ClientModel clientModel;
    private PaymentTypeModel paymentTypeModel;

    public BillingModel() {
    }

    public BillingModel(EventModel eventModel, ClientModel clientModel, PaymentTypeModel paymentTypeModel) {
        this.setEventModel(eventModel);
        this.setClientModel(clientModel);
        this.setPaymentTypeModel(paymentTypeModel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public PaymentTypeModel getPaymentTypeModel() {
        return paymentTypeModel;
    }

    public void setPaymentTypeModel(PaymentTypeModel paymentTypeModel) {
        this.paymentTypeModel = paymentTypeModel;
    }

    public String toString() {
        return "Billing: {" +
                "id=" + getId() +
                ", event='" + getEventModel() + '\'' +
                ", client=" + getClientModel() + '\'' +
                ", paymentType=" + getPaymentTypeModel() +
                '}';
    }
}