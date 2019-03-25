package com.model;

import com.beans.MessageHolder;
import com.beans.PasswordConnectBean;
import com.beans.UserConnectBean;

 
public class ConnectionModel {
    public MessageHolder connectNewUser(String userName, String password) {
        MessageHolder msgUser = connectUserBean_.validUserConnection(userName);
        MessageHolder msgPassword = connectPassBean_.validPasswordConnection(password);
        System.err.println(msgPassword.m_code);
        if (msgUser.m_code != 200 || msgPassword.m_code != 200)
            return msgUser.m_code != 200 ? new MessageHolder(300, msgUser.m_message) : new MessageHolder(300, msgPassword.m_message);
        return new MessageHolder(200, "La connexion a été effectué avec succès");
    }

    private UserConnectBean connectUserBean_ = new UserConnectBean();
    private PasswordConnectBean connectPassBean_ = new PasswordConnectBean();
}
