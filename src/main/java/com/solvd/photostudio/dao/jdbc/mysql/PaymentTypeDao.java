package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPaymentTypeDao;
import com.solvd.photostudio.models.AdministratorModel;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.PaymentTypeModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeDao extends AbstractDao implements IPaymentTypeDao {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
    private static final String DELETE = "DELETE FROM payment_type WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM payment_type ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM payment_type WHERE id=?";
    private static final String INSERT = "INSERT INTO payment_type(name) VALUES(?)";
    private static final String UPDATE = "UPDATE payment_type SET name=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public PaymentTypeModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                PaymentTypeModel paymentType = new PaymentTypeModel();
                paymentType.setId(resultSet.getInt("id"));
                paymentType.setName(resultSet.getString("name"));
                return paymentType;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<PaymentTypeModel> getAllEntity() {
        List<PaymentTypeModel> allPayments = new ArrayList<>();
        try {
            getResultSet(FIND_ALL);
            while (resultSet.next()) {
                PaymentTypeModel paymentType = new PaymentTypeModel();
                paymentType.setId(resultSet.getInt("id"));
                paymentType.setName(resultSet.getString("name"));
                allPayments.add(paymentType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return allPayments;
    }

    @Override
    public void createEntity(PaymentTypeModel paymentTypeModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            stmt.setString(1, paymentTypeModel.getName());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(PaymentTypeModel paymentTypeModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(2, paymentTypeModel.getId());
            stmt.setString(1, paymentTypeModel.getName());
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
