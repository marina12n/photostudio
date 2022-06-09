package com.solvd.photostudio.patterns;

import com.solvd.photostudio.patterns.mvc.Client;
import com.solvd.photostudio.patterns.mvc.ClientController;
import com.solvd.photostudio.patterns.mvc.ClientView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MVSExecutor {
    private static final Logger LOGGER = LogManager.getLogger(MVSExecutor.class);
    private static Client model;

    public static void main(String[] args) {
        Client model = retrieveClientFromData();

        ClientView view = new ClientView();

        ClientController controller = new ClientController(model, view);

        controller.updateView();
        controller.setClientName("John");
        controller.updateView();
    }

    private static Client retrieveClientFromData() {
        Client client = new Client();
        client.setName("Mark");
        client.setAge(25);
        return client;
    }
}
