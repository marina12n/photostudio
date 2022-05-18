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
    private static final String FIND_ALL = "SELECT schedule.id, schedule.name, photographer.name, client.name, administrator.name FROM photostudio.schedule INNER JOIN photostudio.photographer ON schedule.photographer_id=photographer.id LEFT JOIN photostudio.administrator ON schedule.administrator_id=administrator.id INNER JOIN photostudio.client ON schedule.client_id=client.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE schedule.id=?";
    private static final String INSERT = "INSERT INTO schedule(event_id, client_id, payment_type_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE schedule SET event_id=?, client_id=?, payment_type_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public ScheduleModel getEntity(long id) {
        ScheduleModel schedule = new ScheduleModel();
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographers(getSchedulePhotographers(resultSet.getInt("schedule.photographer_id")));
                schedule.setAdministratorModel(new AdministratorModel(resultSet.getString("administrator.name")));
                schedule.setClients(getScheduleClients(resultSet.getInt("schedule.client_id")));
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
                schedule.setName(resultSet.getString("name"));
                schedule.setPhotographers(getSchedulePhotographers(resultSet.getInt("schedule.photographer_id")));
                schedule.setAdministratorModel(new AdministratorModel(resultSet.getString("administrator.name")));
                schedule.setClients(getScheduleClients(resultSet.getInt("schedule.client_id")));
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
            stmt.setString(2, scheduleModel.getPhotographers().get(scheduleModel.getId()).getName());
            stmt.setString(3, scheduleModel.getClients().get(scheduleModel.getId()).getName());
            stmt.setString(4, scheduleModel.getAdministratorModel().getName());
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
            stmt.setString(2, scheduleModel.getPhotographers().get(scheduleModel.getId()).getName());
            stmt.setString(3, scheduleModel.getClients().get(scheduleModel.getId()).getName());
            stmt.setString(4, scheduleModel.getAdministratorModel().getName());
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

    private List<ClientModel> getScheduleClients(int client_id) {
        List<ClientModel> clients = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM client where id = ?");
            stmt.setLong(1, client_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                ClientModel client = new ClientModel();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setDateOfRegistration(resultSet.getString("date_of_registration"));
                clients.add(client);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return clients;
    }

    private List<PhotographerModel> getSchedulePhotographers(int photographer_id) {
        List<PhotographerModel> photographers = new ArrayList<>();
        try {
            stmt = getConnection().prepareStatement("SELECT * FROM photographer where id = ?");
            stmt.setLong(1, photographer_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                PhotographerModel photographer = new PhotographerModel();
                photographer.setId(resultSet.getInt("id"));
                photographer.setName(resultSet.getString("name"));
                photographer.setCameras(photographer.getCameras());
                photographers.add(photographer);
            }
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
        return photographers;
    }
}
