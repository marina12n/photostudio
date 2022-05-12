package com.solvd.photostudio;
import com.solvd.photostudio.dao.jdbc.mysql.*;
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
        CameraDao camera = new CameraDao();
        LOGGER.info(camera.getAllEntity());
        AdministratorDao administrator = new AdministratorDao();
        LOGGER.info(administrator.getAllEntity());
        ClientHasEventDao clientHasEventDao = new ClientHasEventDao();
        LOGGER.info(clientHasEventDao.getAllEntity());
    }
}
