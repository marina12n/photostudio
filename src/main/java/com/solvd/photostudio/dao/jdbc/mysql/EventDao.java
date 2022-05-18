package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IEventDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ClientModel;
import com.solvd.photostudio.models.EventModel;
import com.solvd.photostudio.models.LocationModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao extends AbstractDao implements IEventDao {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
    private static final String DELETE = "DELETE FROM event WHERE id=?";
    private static final String FIND_ALL = "SELECT event.id, event.name, location.name FROM event INNER JOIN photostudio.location ON location_id=location.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE event.id=?";
    private static final String INSERT = "INSERT INTO event(name, location_id) VALUES(?, ?)";
    private static final String UPDATE = "UPDATE event SET name=?, location_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public EventModel getEntity(long id) {
        EventModel event = new EventModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {

                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setLocations(getEventLocations(resultSet.getInt("event.location_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return event;
    }

    @Override
    public List<EventModel> getAllEntity() {
        List<EventModel> allEvents = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                EventModel event = new EventModel();
                event.setId(resultSet.getInt("id"));
                event.setName(resultSet.getString("name"));
                event.setLocations(getEventLocations(resultSet.getInt("event.location_id")));
                allEvents.add(event);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allEvents;
    }

    @Override
    public void createEntity(EventModel eventModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, eventModel.getName());
            stmt.setString(2, eventModel.getLocations().get(eventModel.getId()).getName());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(EventModel eventModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(3, eventModel.getId());
            stmt.setString(1, eventModel.getName());
            stmt.setString(2, eventModel.getLocations().get(eventModel.getId()).getName());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void deleteEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(DELETE);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    private List<LocationModel> getEventLocations(int location_id) {
        List<LocationModel> locations = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM location where id = ?");
            stmt.setLong(1, location_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                LocationModel location = new LocationModel();
                location.setId(resultSet.getInt("id"));
                location.setName(resultSet.getString("name"));
                locations.add(location);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return locations;
    }
}
