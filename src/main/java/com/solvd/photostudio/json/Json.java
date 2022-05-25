package com.solvd.photostudio.json;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.json.JsonReadContext;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Json {
    private static final Logger LOGGER = LogManager.getLogger(Json.class);

    public static void jsonW() {
        Assistant assistant = new Assistant();
        assistant.setName("Viktor");
        assistant.setAge(30);
        assistant.setPosition("Assistant photographer");
        assistant.setSalary(400);


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

    public static void jsonR(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            Assistant assistant = mapper.readValue(new File("D:\\java\\photostudio\\src\\main\\resources\\assistant_json.xml"), Assistant.class);

            String prettyAssistant1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(assistant);

            LOGGER.info(prettyAssistant1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}