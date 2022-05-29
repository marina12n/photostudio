package com.solvd.photostudio.myBatis;
import com.solvd.photostudio.dao.IAdministratorDAO;
import com.solvd.photostudio.models.AdministratorModel;
import org.apache.ibatis.session.SqlSession;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyBatisExecutor {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisExecutor.class);

    public static void main(String[] args) throws IOException {
        MyBatisSQLFactory factory = MyBatisSQLFactory.newInstance("mybatis-config.xml");
        SqlSession session = factory.getFactory().openSession();
        IAdministratorDAO mapper = session.getMapper(IAdministratorDAO.class);
        //AdministratorModel administratorModel = mapper.getEntity(1);
        //mapper.deleteEntity(4);


        //AdministratorModel administratorModel = mapper.getEntity(2);
        //administratorModel.setName("Olena");
        //mapper.updateEntity(administratorModel);
        AdministratorModel administratorModel = new AdministratorModel("Test Admin");

        mapper.createEntity(administratorModel);
        session.commit();
        List<AdministratorModel> administratorModelList = mapper.getAllEntity();
        session.close();

        //LOGGER.info(administratorModel);
        LOGGER.info(administratorModelList);
    }
}
