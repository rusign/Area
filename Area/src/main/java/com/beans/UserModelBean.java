package com.beans;

import com.databases.MysqlHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
 
public class UserModelBean extends RegistrationModelBean {
    @Override
    public boolean isExist(String str) {
        try {
            String existing = "";
            ResultSet rs = MysqlHandler.getDbCon().query("SELECT UserName FROM USERS WHERE UserName LIKE '" + str + "'");
            while (rs.next()) {
                existing = rs.getString("UserName");
            }
            return existing.equals(str);
        } catch (SQLException e) {
            return false;
        }
    }

    public MessageHolder validUserName(String property) {
        return validProperty(property, "Erreur: l'identifiant est trop petit ou existe déjà",
                            "OK");
    }
}
