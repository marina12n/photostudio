package com.solvd.photostudio.myBatis;
import com.solvd.photostudio.dao.IAdministratorDAO;
import com.solvd.photostudio.models.AdministratorModel;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyBatisExecutor {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisExecutor.class);

    public static void main(String[] args) throws IOException {
        MyBatisSQLFactory factory = MyBatisSQLFactory.newInstance("mybatis-config.xml");
        SqlSessionFactory sessionFactory = factory.getFactory();
        SqlSession session = sessionFactory.openSession();
        IAdministratorDAO mapper = session.getMapper(IAdministratorDAO.class);
        AdministratorModel administratorModel = mapper.getEntity(1);
        LOGGER.info(administratorModel);
    }
}
