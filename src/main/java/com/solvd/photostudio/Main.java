package com.solvd.photostudio;
import com.solvd.photostudio.dao.jdbc.mysql.*;
import com.solvd.photostudio.models.ClientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CLientDao client = new CLientDao();
        LOGGER.info(client.getAllEntity());
        PriceListDao price = new PriceListDao();
        LOGGER.info(price.getAllEntity());
        BillingDao billing = new BillingDao();
        LOGGER.info(billing.getAllEntity());
        LOGGER.info(billing.getEntity(2));
        CameraDao camera = new CameraDao();
        LOGGER.info(camera.getAllEntity());
        AdministratorDao administrator = new AdministratorDao();
        LOGGER.info(administrator.getAllEntity());
        ClientHasEventDao clientHasEventDao = new ClientHasEventDao();
        LOGGER.info(clientHasEventDao.getAllEntity());
        LOGGER.info("----------------------------------------------------");
        //ClientModel clmod = new ClientModel();
        //client.createEntity(clmod);
        //LOGGER.info(client.getAllEntity());
        //client.deleteEntity(5);
        ClientModel test_client = new ClientModel();
        test_client = client.getEntity(4);
        LOGGER.info(test_client);
        test_client.setName("John Onumah");
        test_client.setDateOfRegistration("15.05.2022");
        client.updateEntity(test_client);
        LOGGER.info(client.getEntity(4));

    }
}
