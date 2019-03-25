package com.getter;

import com.network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetGeoloc extends AGet {

    private static final String _key = "AIzaSyBst-f3V5q8UUCQk_1UCcFB8vcTfgKDcO0";
    JSONObject data;

    public GetGeoloc(String token) {
        super(token);
    }

    @Override
    public void update()
    {
        try {
            HttpClient client = new HttpClient("https://www.googleapis.com/geolocation/v1/geolocate?key=" + _key );
            client.setRequestMethod("GET");
            client.addHeader("Content-Type", "application/json");
            client.addData("none", "none");
            JSONObject jsonObj = new JSONObject(client.send());
            data = ((JSONObject)(jsonObj.get("location")));
            System.out.println("lat = " +data.get("lat"));
            System.out.println("lon = " +data.get("lng"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String dataWanted)
    {
        return data.getString(dataWanted);
    }

    @Override
    public String getDataString() {
        return "Latitude :" + data.get("lat") + "\n longitude :" + data.get("lng") + "\n";
    }
}
