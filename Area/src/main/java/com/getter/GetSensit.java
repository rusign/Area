package com.getter;

import com.network.HttpClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetSensit extends AGet {

    JSONObject data;

    public GetSensit(String token) {
        super(token);

        
    }

    @Override
    public void update()
    {
        try {
            HttpClient client = new HttpClient("https://api.sensit.io/v1/devices/8468/sensors/33904");
            client.setRequestMethod("GET");
            client.addHeader("Authorization", "Bearer " + this.token);
            JSONObject jsonObj = new JSONObject(client.send());
            JSONArray array = (JSONArray)(((JSONObject)(jsonObj.get("data"))).get("history"));
            this.data = (JSONObject) array.get(0);
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
        return getData("data").split(":")[0];
    }
}
