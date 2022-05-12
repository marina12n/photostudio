package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IEventDao;
import com.solvd.photostudio.models.EventModel;

import java.util.List;

public class EventDao extends AbstractDao implements IEventDao {

    @Override
    public EventModel getEntity(long id) {
        return null;
    }

    @Override
    public List<EventModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(EventModel eventModel) {

    }

    @Override
    public void updateEntity(EventModel eventModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
