package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IScheduleDao;
import com.solvd.photostudio.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao extends AbstractDao implements IScheduleDao {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM schedule WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM schedule";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE schedule.id=?";
    private static final String INSERT = "INSERT INTO schedule(name, photographer_id, client_id, administrator_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE schedule SET name=?, photographer_id=?, client_id=?, administrator_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ScheduleModel getEntity(long id) {
        ScheduleModel schedule = new ScheduleModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                schedule.setId(resultSet.getInt("id"));
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographerModel(new PhotographerDao().getEntity(resultSet.getInt("photographer_id")));
                schedule.setClientModel(new CLientDao().getEntity(resultSet.getInt("client_id")));
                schedule.setAdministratorModel(new AdministratorDao().getEntity(resultSet.getInt("administrator_id")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return schedule;
    }

    @Override
    public List<ScheduleModel> getAllEntity() {
        List<ScheduleModel> allSchedule = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                ScheduleModel schedule = new ScheduleModel();
                schedule.setId(resultSet.getInt("id"));
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographerModel(new PhotographerDao().getEntity(resultSet.getInt("photographer_id")));
                schedule.setClientModel(new CLientDao().getEntity(resultSet.getInt("client_id")));
                schedule.setAdministratorModel(new AdministratorDao().getEntity(resultSet.getInt("administrator_id")));
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
            stmt.setInt(2, scheduleModel.getPhotographerModel().getId());
            stmt.setInt(3, scheduleModel.getClientModel().getId());
            stmt.setInt(4, scheduleModel.getPhotographerModel().getId());
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
            stmt.setInt(2, scheduleModel.getPhotographerModel().getId());
            stmt.setInt(3, scheduleModel.getClientModel().getId());
            stmt.setInt(4, scheduleModel.getPhotographerModel().getId());
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
