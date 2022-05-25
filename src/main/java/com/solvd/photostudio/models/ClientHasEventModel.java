package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientHasEventModel {
    private static final Logger LOGGER = LogManager.getLogger(ClientHasEventModel.class);
    private int id;
    private ClientModel clientModel;
    private EventModel eventModel;

    public ClientHasEventModel() {
    }

    public ClientHasEventModel(String event, ClientModel clientModel, EventModel eventModel) {
        this.setClientModel(clientModel);
        this.setEventModel(eventModel);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public EventModel getEventModel() {
        return eventModel;
    }

    public void setEventModel(EventModel eventModel) {
        this.eventModel = eventModel;
    }

    @Override
    public String toString() {
        return "ClientHasEvent: {" +
            "id=" + getId() +
            ", event='" + getEventModel() + '\'' +
            ", client=" + getClientModel() +
            '}';
}

}
