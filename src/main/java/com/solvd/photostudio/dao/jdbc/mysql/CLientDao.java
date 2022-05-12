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
    private static final String UPDATE = "UPDATE user SET name=?, phone_number=?, date_of_registration=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ClientModel getEntity(long id) {
        return null;
    }

    @Override
    public List<ClientModel> getAllEntity() {
        List<ClientModel> allClients = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                ClientModel client = new ClientModel();
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

    }


    @Override
    public void updateEntity(ClientModel clientModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
