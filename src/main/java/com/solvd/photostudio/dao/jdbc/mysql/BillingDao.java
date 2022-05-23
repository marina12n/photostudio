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
    private static final String FIND_ALL = "SELECT billing.id, payment_type.name, event.name, client.name, client.phone_number FROM photostudio.billing INNER JOIN photostudio.event ON billing.event_id=event.id LEFT JOIN photostudio.payment_type ON billing.payment_type_id=payment_type.id INNER JOIN photostudio.client ON billing.client_id=client.id";
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
                billing.setEvents(getBillingEvents(resultSet.getInt("event_id")));
                billing.setClients(getBillingClients(resultSet.getInt("client_id")));
                billing.setPaymentType(new PaymentTypeModel(resultSet.getString("payment_type.name")));
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
                billing.setEvents(getBillingEvents(resultSet.getInt("event_id")));
                billing.setClients(getBillingClients(resultSet.getInt("client_id")));
                billing.setPaymentType(new PaymentTypeModel(resultSet.getString("payment_type.name")));
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
            stmt.setString(1, billingModel.getEvents().get(billingModel.getId()).getName());
            stmt.setString(2, billingModel.getClients().get(billingModel.getId()).getName());
            stmt.setString(3, billingModel.getPaymentType().getName());
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
            stmt.setString(1, billingModel.getEvents().get(billingModel.getId()).getName());
            stmt.setString(2, billingModel.getClients().get(billingModel.getId()).getName());
            stmt.setString(3, billingModel.getPaymentType().getName());
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

    private List<EventModel> getBillingEvents(int event_id) {
        List<EventModel> events = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM event where id = ?");
            stmt.setLong(1, event_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                EventModel event = new EventModel();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setLocationModel(event.getLocationModel());
                events.add(event);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return events;
    }

    private List<ClientModel> getBillingClients(int client_id) {
        List<ClientModel> clients = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM client where id = ?");
            stmt.setLong(1, client_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                ClientModel client = new ClientModel();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setDateOfRegistration(resultSet.getString("date_of_registration"));
                clients.add(client);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return clients;
    }
}