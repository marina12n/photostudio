package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.ILocationDao;
import com.solvd.photostudio.models.LocationModel;

import java.util.List;

public class LocationDao extends AbstractDao implements ILocationDao {

    @Override
    public LocationModel getEntity(long id) {
        return null;
    }

    @Override
    public List<LocationModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(LocationModel locationModel) {

    }

    @Override
    public void updateEntity(LocationModel locationModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
