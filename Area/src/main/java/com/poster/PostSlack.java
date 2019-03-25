package com.poster;

import com.network.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;

public class PostSlack extends APost {
    public PostSlack(String token)
    {
        super(token);
    }

    @Override
    public void send(String id, String api, String message)
    {
        try {
            HttpClient client = new HttpClient("https://slack.com/api/channels.list");
            client.setUrlParameters("token=" + this.token);
            client.setRequestMethod("POST");
            JSONObject obj = new JSONObject(client.send());

            System.out.println(obj);

            JSONArray arr = (JSONArray) obj.get("channels");

            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject tmp = (JSONObject) arr.get(i);

                if (tmp.getString("name") == id)
                {
                    id = tmp.getString("id");
                }
            }

            client = new HttpClient("https://slack.com/api/chat.postMessage");
            client.setRequestMethod("POST");

            String urlparameters = "token=" + this.token;
            urlparameters += "&text=" + URLEncoder.encode(message, "UTF-8");
            urlparameters += "&username=" + api;
            urlparameters += "&channel=" + id;
            client.setUrlParameters(urlparameters);

            client.send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
