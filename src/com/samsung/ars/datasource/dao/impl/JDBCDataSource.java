package com.samsung.ars.datasource.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDataSource {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/ars";

    public static final String USER_NAME = "root";

    public static final String PASSWORD = "root";

    public static Connection getconnection() {
	Connection conn = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return conn;
    }
    
}
