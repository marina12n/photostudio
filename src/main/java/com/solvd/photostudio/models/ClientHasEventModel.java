package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientHasEventModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientHasEventModel.class);
    private String event;
    private String client;

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
        return "[Event: " + event + "; Client: " + client + "]";
    }
}
