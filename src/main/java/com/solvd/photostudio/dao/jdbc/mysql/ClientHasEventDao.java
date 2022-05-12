package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IClientHasEventDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ClientModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.List;

public class ClientHasEventDao extends AbstractDao implements IClientHasEventDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM billing WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM client_has_event FULL JOIN event ON event_id=event.id";
    private static final String FIND_BY_ID = "SELECT * FROM billing WHERE id=?";
    private static final String INSERT = "INSERT INTO billing(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";


    @Override
    public ClientModel getEntity(long id) {
        return null;
    }

    @Override
    public List<ClientModel> getAllEntity() {
        return null;
    }

    @Override
    public List<CameraModel> createEntity(ClientModel clientModel) {

        return null;
    }

    @Override
    public void updateEntity(ClientModel clientModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
