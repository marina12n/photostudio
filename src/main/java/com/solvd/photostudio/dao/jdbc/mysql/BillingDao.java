package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IBillingDao;
import com.solvd.photostudio.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillingDao extends AbstractDao implements IBillingDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM billing WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM billing";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE billing.id=?";
    private static final String INSERT = "INSERT INTO billing(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE billing SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public BillingModel getEntity(long id) {
        BillingModel billing = new BillingModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                billing.setId(resultSet.getInt("id"));
                billing.setEventModel(new EventDao().getEntity(resultSet.getInt("event_id")));
                billing.setClientModel(new CLientDao().getEntity(resultSet.getInt("client_id")));
                billing.setPaymentTypeModel(new PaymentTypeDao().getEntity(resultSet.getInt("payment_type_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return billing;
    }

    @Override
    public List<BillingModel> getAllEntity() {
        List<BillingModel> allBilling = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                BillingModel billing = new BillingModel();
                billing.setId(resultSet.getInt("id"));
                billing.setEventModel(new EventDao().getEntity(resultSet.getInt("event_id")));
                billing.setClientModel(new CLientDao().getEntity(resultSet.getInt("client_id")));
                billing.setPaymentTypeModel(new PaymentTypeDao().getEntity(resultSet.getInt("payment_type_id")));
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
            stmt.setInt(1, billingModel.getEventModel().getId());
            stmt.setInt(2, billingModel.getClientModel().getId());
            stmt.setInt(3, billingModel.getPaymentTypeModel().getId());
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
            stmt.setInt(1, billingModel.getEventModel().getId());
            stmt.setInt(2, billingModel.getClientModel().getId());
            stmt.setInt(3, billingModel.getPaymentTypeModel().getId());
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

    @Override
    public BillingModel getEntityByPayment(int id) {
        BillingModel billing = new BillingModel();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM billing WHERE payment_type_id=?");
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                billing.setId(resultSet.getInt("id"));
                billing.setEventModel(new EventDao().getEntity(resultSet.getInt("event_id")));
                billing.setClientModel(new CLientDao().getEntity(resultSet.getInt("client_id")));
                billing.setPaymentTypeModel(new PaymentTypeDao().getEntity(resultSet.getInt("payment_type_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return billing;
    }

}