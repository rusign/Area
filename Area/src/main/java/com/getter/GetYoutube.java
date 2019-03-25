package com.getter;

import com.network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetYoutube extends AGet{


    private static final String _key = "AIzaSyBst-f3V5q8UUCQk_1UCcFB8vcTfgKDcO0";
    String _comment;
    private static String _id;
    public GetYoutube(String token) {
        super(token);
    }

    public static void setVidId(String id) {
        _id = id;
    }

    @Override
    public void update()
    {
        try {
            HttpClient client = new HttpClient("https://www.googleapis.com/youtube/v3/commentThreads?key=" + _key + "&part=snippet&videoId=" + _id + "&maxResults=1");
            client.setRequestMethod("GET");
            JSONObject jsonObj = new JSONObject(client.send());
            _comment =  ((JSONObject)(((JSONObject)(((JSONObject)(((JSONObject)(((JSONArray)(jsonObj.get("items"))).get(0))).get("snippet"))).get("topLevelComment"))).get("snippet"))).getString("textDisplay");
            System.out.print(_comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String dataWanted)
    {
        return _comment;
    }

    @Override
    public String getDataString()
    {
        return _comment;
    }
}
