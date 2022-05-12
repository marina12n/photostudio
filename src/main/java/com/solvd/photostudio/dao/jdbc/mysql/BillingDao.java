package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IBillingDao;
import com.solvd.photostudio.models.BillingModel;

import java.util.List;

public class BillingDao extends AbstractDao implements IBillingDao {

    @Override
    public BillingModel getEntity(long id) {
        return null;
    }

    @Override
    public List<BillingModel> getAllEntity() {
        return null;
    }

    @Override
    public void createEntity(BillingModel billingModel) {

    }

    @Override
    public void updateEntity(BillingModel billingModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
