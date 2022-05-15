package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPriceListDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.ClientModel;
import com.solvd.photostudio.models.PriceListModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceListDao extends AbstractDao implements IPriceListDao {
    private static final Logger LOGGER = LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM price_list WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM price_list FULL JOIN event ON event_id=event.id";
    private static final String FIND_BY_ID = FIND_ALL + " WHERE price_list.id=?";
    private static final String INSERT = "INSERT INTO price_list(name, price, event_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE price_list SET name=?, price=?, event_id=? WHERE id=?";
    private PreparedStatement stmt;

    @Override
    public PriceListModel getEntity(long id) {
        try {
            stmt = getConnection().prepareStatement(FIND_BY_ID);
            stmt.setLong(1, id);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                PriceListModel price_list = new PriceListModel();
                price_list.setId(resultSet.getInt("id"));
                price_list.setName(resultSet.getString("name"));
                price_list.setPrice(resultSet.getString("price"));
                price_list.setEvent(resultSet.getString("event.name"));
                return price_list;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }

    @Override
    public List<PriceListModel> getAllEntity() {
            List<PriceListModel> allPrices = new ArrayList<>();
            try {
                getResultSet(FIND_ALL);
                while (resultSet.next()) {
                    PriceListModel price = new PriceListModel();
                    price.setId(resultSet.getInt("id"));
                    price.setName(resultSet.getString("name"));
                    price.setPrice(resultSet.getString("price"));
                    price.setEvent(resultSet.getString("event.name"));
                    allPrices.add(price);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
            return allPrices;
    }

    @Override
    public void createEntity(PriceListModel priceListModel) {
        try {
            stmt = getConnection().prepareStatement(INSERT);
            //stmt.setInt(1, clientModel.getId());
            stmt.setString(1, priceListModel.getName());
            stmt.setString(2, priceListModel.getPrice());
            stmt.setString(3, priceListModel.getEvent());
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    @Override
    public void updateEntity(PriceListModel priceListModel) {
        try {
            stmt = getConnection().prepareStatement(UPDATE);
            stmt.setInt(4, priceListModel.getId());
            stmt.setString(1, priceListModel.getName());
            stmt.setString(2, priceListModel.getPrice());
            stmt.setString(3, priceListModel.getEvent());
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
