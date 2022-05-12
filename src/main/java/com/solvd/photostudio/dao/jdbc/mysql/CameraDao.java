package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.ICameraDao;
import com.solvd.photostudio.models.CameraModel;

import java.util.List;

public class CameraDao extends AbstractDao implements ICameraDao {

    @Override
    public CameraModel getEntity(long id) {
        return null;
    }

    @Override
    public List<CameraModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(CameraModel cameraModel) {

    }

    @Override
    public void updateEntity(CameraModel cameraModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
