package com.getter;

import com.network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetMovieDesc extends AGet {

    private static final String _key = "jiv5uoP3E9msh3dNYNuHfouco07zp1g5Z4EjsnZUz7IcXuODXq";

    String _desc = "";

    public GetMovieDesc(String token) {
        super(token);
    }

    @Override
    public void update()
    {
        try {
            HttpClient cl = new HttpClient("https://community-netflix-roulette.p.mashape.com/api.php?title=" + this.token);
            cl.setRequestMethod("GET");
            cl.addHeader("X-Mashape-Key", _key);
            cl.addHeader("Accept", "application/json");
            String res = cl.send();
            JSONObject obj = new JSONObject(res);
            _desc = obj.getString("summary");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String dataWanted)
    {
        return _desc;
    }

    @Override
    public String getDataString()
    {
        return _desc;
    }
}
