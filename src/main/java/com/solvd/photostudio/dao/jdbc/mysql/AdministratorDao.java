package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IAdministratorDAO;
import com.solvd.photostudio.models.AdministratorModel;
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
    private static final String UPDATE = "UPDATE administrator SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public AdministratorModel getEntity(long id) {
        AdministratorModel admin = new AdministratorModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return admin;
    }


    @Override
    public List<AdministratorModel> getAllEntity() {
            List<AdministratorModel> allAdministrators = new ArrayList<>();
            try {
                getResultSet(FIND_ALL);
                while (resultSet.next()) {
                    AdministratorModel admin = new AdministratorModel();
                    admin.setId(resultSet.getInt("id"));
                    admin.setName(resultSet.getString("name"));
                    allAdministrators.add(admin);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
            return allAdministrators;
        }

    @Override
    public void createEntity(AdministratorModel administratorModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, administratorModel.getName());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(AdministratorModel administratorModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(2, administratorModel.getId());
            stmt.setString(1, administratorModel.getName());
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
