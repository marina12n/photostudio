package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IScheduleDao;
import com.solvd.photostudio.models.BillingModel;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ScheduleModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao extends AbstractDao implements IScheduleDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM schedule WHERE id=?";
    private static final String FIND_ALL = "SELECT schedule.id, schedule.name, photographer.name, client.name, administrator.name FROM photostudio.schedule INNER JOIN photostudio.photographer ON schedule.photographer_id=photographer.id LEFT JOIN photostudio.administrator ON schedule.administrator_id=administrator.id INNER JOIN photostudio.client ON schedule.client_id=client.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE schedule.id=?";
    private static final String INSERT = "INSERT INTO schedule(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE schedule SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ScheduleModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographer(resultSet.getString("photographer.name"));
                schedule.setClient(resultSet.getString("client.name"));
                schedule.setAdministrator(resultSet.getString("administrator.name"));
                return schedule;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<ScheduleModel> getAllEntity() {
        List<ScheduleModel> allSchedule = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographer(resultSet.getString("photographer.name"));
                schedule.setClient(resultSet.getString("client.name"));
                schedule.setAdministrator(resultSet.getString("administrator.name"));
                allSchedule.add(schedule);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allSchedule;
    }

    @Override
    public void createEntity(ScheduleModel scheduleModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, scheduleModel.getName());
            stmt.setString(2, scheduleModel.getPhotographer());
            stmt.setString(3, scheduleModel.getClient());
            stmt.setString(4, scheduleModel.getAdministrator());
            stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(ScheduleModel scheduleModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(5, scheduleModel.getId());
            stmt.setString(1, scheduleModel.getName());
            stmt.setString(2, scheduleModel.getPhotographer());
            stmt.setString(3, scheduleModel.getClient());
            stmt.setString(4, scheduleModel.getAdministrator());
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
}
