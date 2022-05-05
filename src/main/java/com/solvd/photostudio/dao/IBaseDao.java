package com.solvd.photostudio.dao;

public interface IBaseDao <T>{

    T getEntity(long id);

    void saveEntity(T t);

    void updateEntity(T t);

    void deleteEntity(long id);
}
