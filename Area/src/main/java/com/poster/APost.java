package com.poster;


public abstract class APost {

    protected String token;

    public APost(String token)
    {
        this.token = token;
    }

    public boolean connect() {
        return true;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public abstract void send(String recipient, String api, String data);
}
