package com.solvd.photostudio.dao;

import com.solvd.photostudio.models.CameraModel;

import java.util.List;

public interface IBaseDao <T>{

    T getEntity(long id);

    List<T> getAllEntity();

    List<CameraModel> createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(long id);
}
