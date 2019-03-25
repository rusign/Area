package com.model;

import com.beans.MessageHolder;
import com.beans.PasswordModelBean;
import com.beans.UserModelBean;
import com.databases.MysqlHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

 
public class RegistrationModel {
    public String registerNewUser(String userName, String password) throws SQLException {
        MessageHolder msgUser = userBean_.validUserName(userName);
        MessageHolder msgPassword = passwordBean_.validPassword(password);
        if (msgUser.m_code != 200 || msgPassword.m_code != 200)
            return msgUser.m_code != 200 ? msgUser.m_message : msgPassword.m_message;
        ResultSet rs = MysqlHandler.getDbCon().query("SELECT MAX(ID) FROM USERS");
        Integer ID = 0;
        while (rs.next()) {
            ID = rs.getInt("MAX(ID)");
        }
        ID = ID + 1;

        MysqlHandler.getDbCon().insert("INSERT INTO USERS (ID, UserName, Password, ACTION1) VALUES ('" + ID.toString() + "', '" + userName + "', '" + password + "','0')");
        return "";
    }

    private UserModelBean userBean_ = new UserModelBean();
    private PasswordModelBean passwordBean_ = new PasswordModelBean();
}
