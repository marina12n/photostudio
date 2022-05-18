package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IClientHasEventDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ClientHasEventModel;
import com.solvd.photostudio.models.ClientModel;
import com.solvd.photostudio.models.EventModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientHasEventDao extends AbstractDao implements IClientHasEventDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM client_has_event WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM client_has_event INNER JOIN client ON client_id=client.id INNER JOIN event ON event_id=event.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE client_has_event.id=?";
    private static final String INSERT = "INSERT INTO client_has_event(client_id, event_id) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE client_has_event SET client_id=?, event_id=?,  WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ClientHasEventModel getEntity(long id) {
        ClientHasEventModel client_has_event = new ClientHasEventModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                client_has_event.setId(resultSet.getInt("id"));
                client_has_event.setClients(getClients(resultSet.getInt("client_has_event.client_id")));
                client_has_event.setEvents(getEvents(resultSet.getInt("client_has_event.event_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return client_has_event;
    }

    @Override
    public List<ClientHasEventModel> getAllEntity() {
        List<ClientHasEventModel> allClientsEvents = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                ClientHasEventModel client_has_event = new ClientHasEventModel();
                client_has_event.setId(resultSet.getInt("id"));
                client_has_event.setClients(getClients(resultSet.getInt("client_has_event.client_id")));
                client_has_event.setEvents(getEvents(resultSet.getInt("client_has_event.event_id")));
                allClientsEvents.add(client_has_event);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allClientsEvents;
    }

    @Override
    public void createEntity(ClientHasEventModel clientHasEventModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, clientHasEventModel.getClients().get(clientHasEventModel.getId()).getName());
            stmt.setString(2, clientHasEventModel.getEvents().get(clientHasEventModel.getId()).getName());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(ClientHasEventModel clientHasEventModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(3, clientHasEventModel.getId());
            stmt.setString(1, clientHasEventModel.getClients().get(clientHasEventModel.getId()).getName());
            stmt.setString(2, clientHasEventModel.getEvents().get(clientHasEventModel.getId()).getName());
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

    private List<EventModel> getEvents(int event_id) {
        List<EventModel> events = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM event where id = ?");
            stmt.setLong(1, event_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                EventModel event = new EventModel();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setLocations(event.getLocations());
                events.add(event);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return events;
    }

    private List<ClientModel> getClients(int client_id) {
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
