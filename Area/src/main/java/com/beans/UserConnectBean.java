package com.beans;

import com.databases.MysqlHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

 
public class UserConnectBean extends ConnectBean {
    @Override
    public boolean isExist(String userName) {
        try {
            ResultSet rs = MysqlHandler.getDbCon().query("SELECT UserName FROM USERS WHERE UserName LIKE '" + userName + "'");
            String existingUser = "";
            while (rs.next()) {
                existingUser = rs.getString("UserName");
            }
            return existingUser.equals(userName);
        } catch (SQLException e) {
            return false;
        }
    }

    public MessageHolder validUserConnection(String user) {
        return validUserForConnect(user, "OK", "Erreur: Identifiant incorrect");
    }
}
