package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.ICameraDao;
import com.solvd.photostudio.models.AdministratorModel;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.PhotographerModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CameraDao extends AbstractDao implements ICameraDao {
    private static final Logger LOGGER = LogManager.getLogger(CameraDao.class);
    private static final String DELETE = "DELETE FROM camera WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM camera";
    private static final String FIND_BY_ID = "SELECT * FROM camera WHERE id=?";
    private static final String INSERT = "INSERT INTO camera(name) VALUES(?)";
    private static final String UPDATE = "UPDATE camera SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public CameraModel getEntity(long id) {
        CameraModel camera = new CameraModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                camera.setId(resultSet.getInt("id"));
                camera.setName(resultSet.getString("name"));
                camera.setPhotographers(getPhotographers(camera.getId()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return camera;
    }

    @Override
    public List<CameraModel> getAllEntity() {
        List<CameraModel> allCameras = new ArrayList<>();

        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                CameraModel camera = new CameraModel();
                camera.setId(resultSet.getInt("id"));
                camera.setName(resultSet.getString("name"));
                allCameras.add(camera);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        allCameras.forEach(cameraModel -> cameraModel.setPhotographers(getPhotographers(cameraModel.getId())));
        return allCameras;
    }

    @Override
    public void createEntity(CameraModel cameraModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, cameraModel.getName());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(CameraModel cameraModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(2, cameraModel.getId());
            stmt.setString(1, cameraModel.getName());
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
    public List<PhotographerModel> getPhotographers(int camera_id) {
        List<PhotographerModel> photographerModels = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM photographer where camera_id = ?");
            stmt.setInt(1, camera_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                PhotographerModel photographerModel = new PhotographerModel();
                photographerModel.setId(resultSet.getInt("id"));
                photographerModel.setName(resultSet.getString("name"));
                photographerModels.add(photographerModel);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return photographerModels;
    }
}
