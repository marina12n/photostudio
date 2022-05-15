package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IBillingDao;
import com.solvd.photostudio.models.BillingModel;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ClientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDao extends AbstractDao implements IBillingDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM billing WHERE id=?";
    private static final String FIND_ALL = "SELECT billing.id, payment_type.name, event.name, client.name, client.phone_number FROM photostudio.billing INNER JOIN photostudio.event ON billing.event_id=event.id LEFT JOIN photostudio.payment_type ON billing.payment_type_id=payment_type.id INNER JOIN photostudio.client ON billing.client_id=client.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE billing.id=?";
    private static final String INSERT = "INSERT INTO billing(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE billing SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public BillingModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                BillingModel billing = new BillingModel();
                billing.setEvent(resultSet.getString("event.name"));
                billing.setClient(resultSet.getString("client.name"));
                billing.setPaymentType(resultSet.getString("payment_type.name"));
                return billing;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
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
    public void createEntity(BillingModel billingModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            //stmt.setInt(1, clientModel.getId());
            stmt.setString(1, billingModel.getEvent());
            stmt.setString(2, billingModel.getClient());
            stmt.setString(3, billingModel.getPaymentType());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(BillingModel billingModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(4, billingModel.getId());
            stmt.setString(1, billingModel.getEvent());
            stmt.setString(2, billingModel.getClient());
            stmt.setString(3, billingModel.getPaymentType());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void deleteEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(DELETE);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }
}