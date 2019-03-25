package com.databases;
import com.mysql.jdbc.Connection;

import java.sql.*;
import java.sql.DriverManager;

public class MysqlHandler {
    public Connection conn;
    private Statement statement;
    public static MysqlHandler db;

    private MysqlHandler() {
        String url= "jdbc:mysql://neo.ovh:4247/";
        String dbName = "area";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "area_main";
        String password = "Area_main";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized MysqlHandler getDbCon() {
        if ( db == null ) {
            db = new MysqlHandler();
        }
        return db;

    }

    public ResultSet query(String query) throws SQLException{
        statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    public int insert(String insertQuery) throws SQLException {
        statement = db.conn.createStatement();
        int result = statement.executeUpdate(insertQuery);
        return result;

    }
}
