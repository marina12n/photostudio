package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPhotographerDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.EventModel;
import com.solvd.photostudio.models.PhotographerModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotographerDao extends AbstractDao implements IPhotographerDao {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
    private static final String DELETE = "DELETE FROM photographer WHERE id=?";
    private static final String FIND_ALL = "SELECT photographer.id, photographer.name, camera.name FROM photographer INNER JOIN photostudio.camera ON camera_id=camera.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE photographer.id=?";
    private static final String INSERT = "INSERT INTO photographer(name, camera_id) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE photographer INNER JOIN photostudio.camera ON camera_id=camera.id SET name=?, camera.name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public PhotographerModel getEntity(long id) {
        PhotographerModel photographer = new PhotographerModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                photographer.setId(resultSet.getInt("id"));
                photographer.setName(resultSet.getString("name"));
                photographer.setCameras(getPhotographerCameras(photographer.getId()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return photographer;
    }

    @Override
    public List<PhotographerModel> getAllEntity() {
        List<PhotographerModel> allPhotographers = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                PhotographerModel photographer = new PhotographerModel();
                photographer.setId(resultSet.getInt("id"));
                photographer.setName(resultSet.getString("name"));
                photographer.setCameras(getPhotographerCameras(photographer.getId()));
                allPhotographers.add(photographer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allPhotographers;
    }

    @Override
    public void createEntity(PhotographerModel photographerModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, photographerModel.getName());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(PhotographerModel photographerModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(3, photographerModel.getId());
            stmt.setString(1, photographerModel.getName());
            stmt.setString(2, photographerModel.getCameras().get(photographerModel.getId()).getName());
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

    private List<CameraModel> getPhotographerCameras(int camera_id) {
        List<CameraModel> cameras = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM camera where id = ?");
            stmt.setLong(1, camera_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CameraModel camera = new CameraModel();
                camera.setId(resultSet.getInt("id"));
                camera.setName(resultSet.getString("name"));
                cameras.add(camera);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return cameras;
    }
}
