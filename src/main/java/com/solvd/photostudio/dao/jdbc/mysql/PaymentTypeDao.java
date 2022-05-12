package com.solvd.photostudio.dao.jdbc.mysql;
import com.solvd.photostudio.dao.IPaymentTypeDao;
import com.solvd.photostudio.models.CameraModel;
import com.solvd.photostudio.models.PaymentTypeModel;

import java.util.List;

public class PaymentTypeDao extends AbstractDao implements IPaymentTypeDao {

    @Override
    public PaymentTypeModel getEntity(long id) {
        return null;
    }

    @Override
    public List<PaymentTypeModel> getAllEntity() {
        return null;
    }

    @Override
    public List<CameraModel> createEntity(PaymentTypeModel paymentTypeModel) {

        return null;
    }

    @Override
    public void updateEntity(PaymentTypeModel paymentTypeModel) {

    }

    @Override
    public void deleteEntity(long id) {

    }
}
