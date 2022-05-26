package com.solvd.photostudio;
import com.solvd.photostudio.dao.jdbc.mysql.*;
import com.solvd.photostudio.models.BillingModel;
import com.solvd.photostudio.models.ClientModel;
import com.solvd.photostudio.models.EventModel;
import com.solvd.photostudio.models.PaymentTypeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Executor {
    private static final Logger LOGGER = LogManager.getLogger(Executor.class);

    public static void main(String[] args) {
        /*PriceListDao price = new PriceListDao();
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

        EventDao eventDao = new EventDao();
        LOGGER.info(eventDao.getAllEntity());

        LocationDao locationDao = new LocationDao();
        LOGGER.info(locationDao.getAllEntity());

        PaymentTypeDao paymentTypeDao = new PaymentTypeDao();
        LOGGER.info(paymentTypeDao.getAllEntity());

        PhotographerDao photographerDao = new PhotographerDao();
        LOGGER.info(photographerDao.getAllEntity());

        ScheduleDao scheduleDao = new ScheduleDao();
        LOGGER.info(scheduleDao.getAllEntity());
        LOGGER.info("----------------------------------------------------");

        CLientDao client = new CLientDao();
        LOGGER.info(client.getAllEntity());
        ClientModel clmod = new ClientModel();
        client.createEntity(clmod);
        LOGGER.info(client.getAllEntity());
        client.deleteEntity(5);
        ClientModel test_client = new ClientModel();
        test_client = client.getEntity(4);
        LOGGER.info(test_client);
        test_client.setName("John Onumah");
        test_client.setDateOfRegistration("15.05.2022");
        client.updateEntity(test_client);
        LOGGER.info(client.getEntity(4));*/
/*         EventDao eventDao = new EventDao();
        LOGGER.info(eventDao.getAllEntity());
              LOGGER.info(eventDao.getEntity(2));

        LocationDao locationDao = new LocationDao();
        LOGGER.info(locationDao.getAllEntity());*/

        // Photographer block
        /*PhotographerDao photographerDao = new PhotographerDao();
        LOGGER.info(photographerDao.getAllEntity());
        photographerDao.createEntity(new PhotographerModel("Joshua King", 3));
        PhotographerModel test_photographer = photographerDao.getEntity(6);
        LOGGER.info(test_photographer);
        test_photographer.setCamera_id(2);
        photographerDao.updateEntity(test_photographer);
        LOGGER.info(photographerDao.getAllEntity());
        LOGGER.info(photographerDao.getEntity(6));*/

        // Camera block
        /*CameraDao camera = new CameraDao();
        LOGGER.info(camera.getAllEntity());
        camera.createEntity(new CameraModel("Sony"));
        CameraModel cameraModel = camera.getEntity(4);
        cameraModel.setName("Phillips");
        camera.updateEntity(cameraModel);
        LOGGER.info(camera.getEntity(4));*/
/*
        BillingDao billing = new BillingDao();
        LOGGER.info(billing.getEntity(4));
        LOGGER.info(billing.getAllEntity());

        EventDao eventDao = new EventDao();
        EventModel eventModel = eventDao.getEntity(2);

        CLientDao clientDao = new CLientDao();
        ClientModel clientModel = clientDao.getEntity(1);*/

//       PaymentTypeDao paymentTypeDao = new PaymentTypeDao();
//       LOGGER.info(paymentTypeDao.getEntity(1));
        //PaymentTypeModel paymentTypeModel = paymentTypeDao.getEntity(1);

/*        BillingModel billingModel = new BillingModel();
        billingModel.setClientModel(clientModel);
        billingModel.setEventModel(eventModel);
        billingModel.setPaymentTypeModel(paymentTypeModel);
        billing.createEntity(billingModel);
        BillingModel billingModelUpdate = billing.getEntity(4);
        billingModelUpdate.setEventModel(eventModel);
        billing.updateEntity(billingModelUpdate);*/
        CameraDao camera = new CameraDao();
        LOGGER.info(camera.getAllEntity());
    }
}
