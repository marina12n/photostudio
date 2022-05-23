package com.solvd.photostudio.dao;

import com.solvd.photostudio.models.EventModel;
import com.solvd.photostudio.models.LocationModel;

import java.util.List;

public interface ILocationDao extends IBaseDao<LocationModel>{
    List<EventModel> getEventsLocation(int id);
}
