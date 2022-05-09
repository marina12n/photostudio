//package com.solvd.photostudio.dao.jdbc.mysql;
//import com.solvd.photostudio.configuration.ConnectionPool;
//import com.solvd.photostudio.dao.IAdministratorDAO;
//import com.solvd.photostudio.models.AdministratorModel;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.*;
//import java.util.ResourceBundle;
//
//public class AdministratorDao implements IAdministratorDAO {
//    private static final Logger LOGGER = LogManager.getLogger(AdministratorDao.class);
//    private static final String DELETE = "DELETE FROM user WHERE id=?";
//    private static final String FIND_ALL = "SELECT * FROM user ORDER BY id";
//    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
//    private static final String FIND_BY_NAME = "SELECT * FROM user WHERE name=?";
//    private static final String INSERT = "INSERT INTO user(name, tel, passwd) VALUES(?, ?, ?)";
//    private static final String UPDATE = "UPDATE user SET name=?, tel=?, passwd=? WHERE id=?";
//
//    private static final ResourceBundle resource = ResourceBundle.getBundle("db");
//    private static final String dbUrl = resource.getString("dbUrl");
//    private static final String dbUsername = resource.getString("dbUsername");
//    private static final String dbPassword = resource.getString("dbPassword");
//
//    @Override
//    public AdministratorModel getEntity(long id) {
//
//        Connection conn = null;
//        ConnectionPool pool = new ConnectionPool(dbUrl, dbUsername, dbPassword, 2);
//        PreparedStatement stmt = null;
//        try {
//                conn = pool.getConnection();
//                stmt = conn.prepareStatement(FIND_BY_ID);
//                stmt.setLong(1, id);
//
//                int rs = stmt.executeUpdate();
//
//            if (rs.next()) {
//                    AdministratorModel admin = new AdministratorModel();
//                    admin.setName(rs.getString("name"));
//
//                    return admin;
//                } else {
//                    return null;
//                }
//        } catch (SQLException e) {
//            LOGGER.info("Bad error");
//            e.printStackTrace();
//        } finally {
//            if (conn != null) {
//                try {
//                    pool.returnConnection(conn);
//                } catch (SQLException e) {
//                    LOGGER.info("Bad error");
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void saveEntity(AdministratorModel administratorModel) {
//
//    }
//
//    @Override
//    public void updateEntity(AdministratorModel administratorModel) {
//
//    }
//
//    @Override
//    public void deleteEntity(long id) {
//
//    }
//}
