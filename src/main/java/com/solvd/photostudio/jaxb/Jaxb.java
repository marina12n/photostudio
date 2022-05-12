package com.solvd.photostudio.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Jaxb {
    private static final Logger LOGGER = LogManager.getLogger(Jaxb.class);

    public void marshal() throws JAXBException, IOException {
        Manager manager = new Manager();
        manager.setId(1);
        manager.setName("Viktor");
        manager.setAge(37);

        JAXBContext context = JAXBContext.newInstance(Manager.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(manager, new File("D:\\java\\photostudio\\src\\main\\resources\\manager.xml"));
    }

    public Manager unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Manager.class);
        return (Manager) context.createUnmarshaller()
                .unmarshal(new FileReader("D:\\java\\photostudio\\src\\main\\resources\\manager.xml"));
    }

    public static void main(String[] args) {
        Jaxb jaxb = new Jaxb();
        try {
            jaxb.marshal();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            jaxb.unmarshall();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
