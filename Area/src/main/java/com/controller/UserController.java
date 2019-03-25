package com.controller;

import com.beans.Scheduler;
import com.getter.AGet;
import com.getter.GetGeoloc;
import com.getter.GetRedtube;
import com.getter.GetYoutube;
import com.poster.APost;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    private Map<String, APost> postMap;
    private Map<String, AGet> getMap;
    //private Scheduler scheduler;

    public UserController() {
        postMap = new HashMap<String, APost>();
        getMap = new HashMap<String, AGet>();
        //scheduler = new Scheduler();

        GetRedtube rd = new GetRedtube("");
        addGet("Redtube", rd);
        GetGeoloc geo = new GetGeoloc("");
        addGet("Geolocalisation", geo);
        GetYoutube you = new GetYoutube("");
        addGet("Youtube", you);
    }

    public void addPost(String api, APost poster) {
        postMap.put(api, poster);
        System.out.println("Post: " + api + " added");
    }

    public void addGet(String api, AGet getter) {
        getMap.put(api, getter);
        System.out.println("Get: " + api + " added");
    }

    public void addSchedule(String name, AGet get, APost post, String opt) {
        Scheduler.addSchedule(name, get, post, opt);
    }

    public AGet getGetter(String api) {
        return getMap.get(api);
    }

    public APost getPoster(String api) {
        return postMap.get(api);
    }

    public boolean removeGetter(String api) {
        if (getMap.containsKey(api)) {
            getMap.remove(api);
            return true;
        }
        return false;
    }

    public boolean removePoster(String api) {
        if (postMap.containsKey(api)) {
            postMap.remove(api);
            return true;
        }
        return false;
    }

    public Map<String, APost> getPostMap() {
        return postMap;
    }

    public Map<String, AGet> getGetMap() {
        return getMap;
    }

    public boolean removeSchedule(String name) {
        return Scheduler.removeSchedule(name);
    }
}
