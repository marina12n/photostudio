package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class ClientHasEventModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientHasEventModel.class);
    private int id;
    private List<ClientModel> clients;
    private List<EventModel> events;

    public ClientHasEventModel() {
    }

    public ClientHasEventModel(String event, List<ClientModel> clients, List<EventModel> events) {
        this.setClients(clients);
        this.setEvents(events);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientModel> clients) {
        this.clients = clients;
    }

    public List<EventModel> getEvents() {
        return events;
    }

    public void setEvents(List<EventModel> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "[id: " + getId() + "Client: " + getClients() + "; Event: " + getEvents() + "]";
    }
}
