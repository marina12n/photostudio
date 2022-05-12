package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.ICameraDao;
import com.solvd.photostudio.models.CameraModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CameraDao extends AbstractDao implements ICameraDao {
    private static final Logger LOGGER = LogManager.getLogger(CameraDao.class);
    private static final String DELETE = "DELETE FROM camera WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM camera ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM camera WHERE id=?";
    private static final String INSERT = "INSERT INTO camera(name) VALUES(?)";
    private static final String UPDATE = "UPDATE user SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public CameraModel getEntity(long id) {
        return null;
    }

    @Override
    public List<CameraModel> getAllEntity() {
        return null;
    }

    @Override
    public List<CameraModel> createEntity(CameraModel cameraModel) {
        List<CameraModel> allCameras = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                CameraModel camera = new CameraModel();
                camera.setName(resultSet.getString("name"));
                allCameras.add(camera);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allCameras;
    }

    @Override
    public void updateEntity(CameraModel cameraModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
