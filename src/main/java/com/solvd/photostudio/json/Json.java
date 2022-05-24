package com.solvd.photostudio.json;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Json {
    private static final Logger LOGGER = LogManager.getLogger(Json.class);

    public static void jsonW() {
    Assistant assistant = new Assistant();
    assistant.setName("Viktor");
    assistant.setAge(30);
    assistant.setPosition("Assistant photographer");
    assistant.setSalary(400);
    }

    ObjectMapper mapper = new ObjectMapper();
    try {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\java\\photostudio\\src\\main\\resources\\assistant_json.xml"), assistant);
        LOGGER.info("Done");

        } catch (JsonGenerationException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
}
