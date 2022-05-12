package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IAdministratorDAO;
import com.solvd.photostudio.models.AdministratorModel;
import com.solvd.photostudio.models.CameraModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorDao extends AbstractDao implements IAdministratorDAO {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
    private static final String DELETE = "DELETE FROM administrator WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM administrator ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM administrator WHERE id=?";
    private static final String INSERT = "INSERT INTO administrator(name) VALUES(?)";
    private static final String UPDATE = "UPDATE user SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public AdministratorModel getEntity(long id) {
        return null;
    }

    @Override
    public List<AdministratorModel> getAllEntity() {
            List<AdministratorModel> allAdministrators = new ArrayList<>();
            try {
                getResultSet(FIND_ALL);
                while (resultSet.next()) {
                    AdministratorModel client = new AdministratorModel();
                    client.setName(resultSet.getString("name"));
                    allAdministrators.add(client);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
            return allAdministrators;
        }

        @Override
        public List<CameraModel> createEntity(AdministratorModel administratorModel) {

            return null;
        }

    @Override
    public void updateEntity(AdministratorModel administratorModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
