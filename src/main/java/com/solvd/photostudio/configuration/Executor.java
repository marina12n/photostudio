package com.solvd.photostudio.configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Executor {
    private static final Logger LOGGER = LogManager.getLogger(Executor.class);
    public static void main(String[] args) {

        ResourceBundle resource = ResourceBundle.getBundle("db");
        String dbUrl = resource.getString("dbUrl");
        String dbUsername = resource.getString("dbUsername");
        String dbPassword = resource.getString("dbPassword");

        Connection conn = null;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUsername, dbPassword, 2);
        try {
            conn = pool.getConnection();
            try (Statement statement = conn.createStatement()) {
                ResultSet res = statement.executeQuery("select * from camera");
                System.out.println("There are below tables:");
                while (res.next()) {
                    //System.out.print(res.getString("id"));
                    System.out.print(res.getString(1));
                    System.out.print(" | ");
                    System.out.print(res.getString(2));
                    System.out.print(" | ");
                    System.out.print(res.getString(1));
                    System.out.print(" | ");
                    System.out.println();
                }
            }
        } catch (SQLException e) {
            LOGGER.info("Bad error");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    pool.returnConnection(conn);
                } catch (SQLException e) {
                    LOGGER.info("Bad error");
                    e.printStackTrace();
                }
            }
        }
    }
}
