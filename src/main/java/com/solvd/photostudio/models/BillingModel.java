package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class BillingModel {
    private static final Logger LOGGER = LogManager.getLogger(BillingModel.class);
    private int id;
    private List<EventModel> events;
    private List<ClientModel> clients;
    private PaymentTypeModel paymentType;

    public BillingModel() {
    }

    public BillingModel(List<EventModel> events, List<ClientModel> clients, PaymentTypeModel paymentType) {
        this.events = events;
        this.clients = clients;
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientModel> clients) {
        this.clients = clients;
    }

    public PaymentTypeModel getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypeModel paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "[" + "id: " + getId() + " Event: " + getEvents() + "; Client: " + getClients() + " Pay: " + getPaymentType() + "]";
    }
}
