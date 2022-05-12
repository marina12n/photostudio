package com.solvd.photostudio.dao;

import java.util.List;

public interface IBaseDao <T>{

    T getEntity(long id);

    List<T> getAllEntity();

    void createEntity(T t);

    void updateEntity(T t);

    void deleteEntity(long id);
}
