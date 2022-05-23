package com.solvd.photostudio.json;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class JsonMain {
    private static final Logger LOGGER = LogManager.getLogger(JsonMain.class);
    public static void main(String[] arg) {
        String jsonSource = "{ \"title\": \"Coder From Scratch\", " +
                "\"name\": \"Information\" }";

        try {
            JsonNode node = Json.parse(jsonSource);
        LOGGER.info(node.get("title").asText());
        LOGGER.info(node.get("name").asText());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
