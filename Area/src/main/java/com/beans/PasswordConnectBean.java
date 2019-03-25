package com.beans;

import com.databases.MysqlHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

 
public class PasswordConnectBean extends ConnectBean {
    @Override
    public boolean isExist(String password) {
        try {
            ResultSet rs = MysqlHandler.getDbCon().query("SELECT Password FROM USERS WHERE Password LIKE '" + password + "'");
            String existingUser = "";
            while (rs.next()) {
                existingUser = rs.getString("Password");
            }
            return existingUser.equals(password);
        } catch (SQLException e) {
            return false;
        }
    }

    public MessageHolder validPasswordConnection(String password) {
        return validUserForConnect(password, "OK", "Erreur: Mot de passe incorrecte");
    }
}
