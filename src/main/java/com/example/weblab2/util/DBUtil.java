package com.example.weblab2.util;

import java.sql.*;

public class DBUtil {
    private Connection connection;
    private Statement statement;

    public DBUtil() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        System.out.println("成功加载数据库驱动！");
        connection= DriverManager.getConnection("jdbc:postgresql://localhost/hit","postgres","20040217");
        statement=connection.createStatement();


    }
    public void close() throws SQLException {
        if(!statement.isClosed()){
            statement.close();
        }
        if(!connection.isClosed()){
            connection.close();
        }
    }
    public ResultSet executeQuery(String sql) throws SQLException {
        ResultSet resultSet=statement.executeQuery(sql);
        return resultSet;
    }
    public void executeUpdate(String sql) throws SQLException {
        statement.executeUpdate(sql);
    }
}
