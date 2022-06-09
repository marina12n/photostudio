package com.solvd.photostudio.patterns.mvc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientView {
    private static final Logger LOGGER = LogManager.getLogger(ClientView.class);
    public void printClientDetails(String clientName, int clientAge) {
        LOGGER.info("Client");
        LOGGER.info("Name: " + clientName);
        LOGGER.info("Age: " + clientAge);
    }
}
