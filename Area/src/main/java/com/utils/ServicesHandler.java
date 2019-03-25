package com.utils;

import com.databases.MysqlHandler;
import servlet.request.ServicesController;

import java.util.ArrayList;
import java.util.List;


public class ServicesHandler {

    public static ServicesHandler sh;
    private List<objForService> list = new ArrayList<objForService>();

    private ServicesHandler(){

    }

    public static synchronized ServicesHandler getSh() {
        if ( sh == null ) {
            sh = new ServicesHandler();
        }
        return sh;
    }

    public List<objForService> getList() {
        return list;
    }

    public void addToList(objForService obj){
        list.add(obj);
    }
}
