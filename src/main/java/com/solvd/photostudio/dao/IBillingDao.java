package com.solvd.photostudio.dao;

import com.solvd.photostudio.models.BillingModel;

public interface IBillingDao extends IBaseDao<BillingModel> {
    BillingModel getEntityByPayment(int id);
}
