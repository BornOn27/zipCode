package com.flodeus.spring.zipCode.service;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public Connection getApplicationSql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/springboot";
        String username = "root";
        String password = "secret@donotshare";
        String className = "com.mysql.cj.jdbc.Driver";

        Class.forName(className);
        return DriverManager.getConnection(url, username,password);
    }
}
