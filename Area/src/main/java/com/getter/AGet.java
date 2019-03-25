package com.getter;


public abstract class AGet {

    protected String token;

    public AGet(String token) {
        this.token = token;
    }

    public boolean connect() {
        return true;
    }

    public String getDataString() {
        return "";
    }

    public abstract void update();
    public abstract String getData(String dataWanted);
}
