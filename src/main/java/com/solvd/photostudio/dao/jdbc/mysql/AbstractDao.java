package com.solvd.photostudio.dao.jdbc.mysql;

import com.solvd.photostudio.configuration.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AbstractDao {
    private Statement statement;
    protected ResultSet resultSet;
    private Connection connection;

    private static final ResourceBundle resource = ResourceBundle.getBundle("db");
    private static final String dbUrl = resource.getString("dbUrl");
    private static final String dbUsername = resource.getString("dbUsername");
    private static final String dbPassword = resource.getString("dbPassword");

    public Connection getConnection () {
        MyConnection.newInstance();
        connection = MyConnection.getConnection(dbUrl, dbUsername, dbPassword);
        return connection;
    }

    public ResultSet getResultSet(String sqlQuery) throws SQLException {
        getConnection();
        statement = connection.createStatement();
        resultSet =  statement.executeQuery(sqlQuery);
        return resultSet;
    }

    public void closeAll() {
        if (resultSet != null)
            try {
                resultSet.close();
            } catch (SQLException ignored) {
            }
        if (statement !=  null)
            try {
                statement.close();
            } catch (SQLException ignored){
            }
        if (connection != null)
            try {
                connection.close();
            } catch (SQLException ignored){
            }
    }
}
