package com.getter;

import com.network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetRedtube extends AGet {

    private JSONObject lastVideo;

    public GetRedtube(String token)
    {
        super(token);
    }

    @Override
    public void update()
    {
        try {
            HttpClient client = new HttpClient("http://api.redtube.com/");
            client.setUrlParameters("data=redtube.Videos.searchVideos&output=json&tags[]=Teen&thumbsize=medium");
            JSONObject obj = new JSONObject(client.send());
            lastVideo = (JSONObject) ((JSONObject) ((JSONArray)(obj.get("videos"))).get(0)).get("video");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String data)
    {
        if (data == "tags")
        {
            String tags = "";
            JSONArray arr = (JSONArray)lastVideo.get(data);
            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject obj = (JSONObject)arr.get(i);
                tags += obj.getString("tag_name") + ' ';
            }
            tags.substring(0, tags.length() - 1);
            return tags;
        }
        return lastVideo.getString(data);
    }

    @Override
    public String getDataString() {
        String data = "";

        data += "Title : " + getData("title");
        data += " Url : " + getData("url");
        data += " Rating : " + getData("rating");
        data += " Duration : " + getData("duration");
        data += " Tags : " + getData("tags");
        return data;
    }
}
