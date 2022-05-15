package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.ILocationDao;
import com.solvd.photostudio.models.AdministratorModel;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.LocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao extends AbstractDao implements ILocationDao {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
    private static final String DELETE = "DELETE FROM location WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM location ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM location WHERE id=?";
    private static final String INSERT = "INSERT INTO location(name) VALUES(?)";
    private static final String UPDATE = "UPDATE location SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public LocationModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                LocationModel location = new LocationModel();
                location.setId(resultSet.getInt("id"));
                location.setName(resultSet.getString("name"));
                return location;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<LocationModel> getAllEntity() {
        List<LocationModel> allLocations = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                LocationModel location = new LocationModel();
                location.setId(resultSet.getInt("id"));
                location.setName(resultSet.getString("name"));
                allLocations.add(location);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allLocations;
    }

    @Override
    public void createEntity(LocationModel locationModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, locationModel.getName());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(LocationModel locationModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(2, locationModel.getId());
            stmt.setString(1, locationModel.getName());
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
