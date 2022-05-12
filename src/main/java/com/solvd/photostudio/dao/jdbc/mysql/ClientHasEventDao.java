package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IClientHasEventDao;
import com.solvd.photostudio.models.ClientModel;

import java.util.List;

public class ClientHasEventDao extends AbstractDao implements IClientHasEventDao {

    @Override
    public ClientModel getEntity(long id) {
        return null;
    }

    @Override
    public List<ClientModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(ClientModel clientModel) {

    }

    @Override
    public void updateEntity(ClientModel clientModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
