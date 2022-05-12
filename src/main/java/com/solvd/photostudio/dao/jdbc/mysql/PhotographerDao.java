package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPhotographerDao;
import com.solvd.photostudio.models.PhotographerModel;

import java.util.List;

public class PhotographerDao extends AbstractDao implements IPhotographerDao {

    @Override
    public PhotographerModel getEntity(long id) {
        return null;
    }

    @Override
    public List<PhotographerModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(PhotographerModel photographerModel) {

    }

    @Override
    public void updateEntity(PhotographerModel photographerModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
