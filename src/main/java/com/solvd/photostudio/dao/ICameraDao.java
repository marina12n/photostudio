package com.solvd.photostudio.dao;

import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.PhotographerModel;

import java.util.List;

public interface ICameraDao extends IBaseDao<CameraModel>{
    List<PhotographerModel> getPhotographers(int id);
}
