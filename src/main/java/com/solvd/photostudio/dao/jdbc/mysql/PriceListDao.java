package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPriceListDao;
import com.solvd.photostudio.models.ClientModel;
import com.solvd.photostudio.models.PriceListModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PriceListDao extends AbstractDao implements IPriceListDao {
    private static final Logger LOGGER = LogManager.getLogger(CLientDao.class);
    private static final String DELETE = "DELETE FROM price_list WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM price_list FULL JOIN event ON event_id=event.id";
    private static final String FIND_BY_ID = "SELECT * FROM price_list WHERE id=?";
    private static final String INSERT = "INSERT INTO price_list(name, price, event_id) VALUES(?, ?, ?)";
    private static final String UPDATE = "UPDATE user SET name=?, price=?, event_id=? WHERE id=?";

    @Override
    public PriceListModel getEntity(long id) {
        return null;
    }

    @Override
    public List<PriceListModel> getAllEntity() {
            List<PriceListModel> allPrices = new ArrayList<>();
            try {
                getResultSet(FIND_ALL);
                while (resultSet.next()) {
                    PriceListModel price = new PriceListModel();
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

    }

    @Override
    public void updateEntity(PriceListModel priceListModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
