package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IClientDao;
import com.solvd.photostudio.models.ClientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CLientDao extends AbstractDao implements IClientDao {
    private static final Logger LOGGER = LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM client WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM client ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM client WHERE id=?";
    private static final String INSERT = "INSERT INTO client(name, phone_number, date_of_registration) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE client SET name=?, phone_number=?, date_of_registration=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ClientModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                ClientModel client = new ClientModel();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setDateOfRegistration(resultSet.getString("date_of_registration"));
                return client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<ClientModel> getAllEntity() {
        List<ClientModel> allClients = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                ClientModel client = new ClientModel();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setDateOfRegistration(resultSet.getString("date_of_registration"));
                allClients.add(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allClients;
    }

    @Override
    public void createEntity(ClientModel clientModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, clientModel.getName());
            stmt.setString(2, clientModel.getPhoneNumber());
            stmt.setString(3, clientModel.getDateOfRegistration());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }


    @Override
    public void updateEntity(ClientModel clientModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(4, clientModel.getId());
            stmt.setString(1, clientModel.getName());
            stmt.setString(2, clientModel.getPhoneNumber());
            stmt.setString(3, clientModel.getDateOfRegistration());
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

  /*  private List<ClientModel> getScheduleClients(int client_id) {
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
    }*/
}