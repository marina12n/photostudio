package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientHasEventModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientHasEventModel.class);
    private int id;
    private String event;
    private String client;

    public ClientHasEventModel() {
        this.setEvent("TEst event");
        this.setClient("Test client");
    }

    public ClientHasEventModel(String event, String client) {
        this.setEvent(event);
        this.setClient(client);
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

    @Override
    public String toString() {
        return "[ID: " + id + "Event: " + event + "; Client: " + client + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
