package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IBillingDao;
import com.solvd.photostudio.models.BillingModel;
import com.solvd.photostudio.models.CameraModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDao extends AbstractDao implements IBillingDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM billing WHERE id=?";
    private static final String FIND_ALL = "SELECT billing.id, payment_type.name, event.name, client.name, client.phone_number FROM photostudio.billing INNER JOIN photostudio.event ON billing.event_id=event.id LEFT JOIN photostudio.payment_type ON billing.payment_type_id=payment_type.id INNER JOIN photostudio.client ON billing.client_id=client.id";
    private static final String FIND_BY_ID = "SELECT * FROM billing WHERE id=?";
    private static final String INSERT = "INSERT INTO billing(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";

    @Override
    public BillingModel getEntity(long id) {
        return null;
    }

    @Override
    public List<BillingModel> getAllEntity() {
        List<BillingModel> allBilling = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                BillingModel billing = new BillingModel();
                billing.setEvent(resultSet.getString("event.name"));
                billing.setClient(resultSet.getString("client.name"));
                billing.setPaymentType(resultSet.getString("payment_type.name"));
                allBilling.add(billing);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allBilling;
    }

    @Override
    public List<CameraModel> createEntity(BillingModel billingModel) {

        return null;
    }

    @Override
    public void updateEntity(BillingModel billingModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}