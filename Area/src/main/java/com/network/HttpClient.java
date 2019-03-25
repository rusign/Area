package com.network;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.HttpURLConnection;


public class HttpClient {

    URL url;
    HttpURLConnection con;
    JSONObject json;
    String urlParameters;

    public HttpClient(String url) throws Exception {
        this.url = new URL(url);
        this.con = (HttpURLConnection)this.url.openConnection();
        con.setDoOutput(true);
        //con.setDoInput(true);
    }

    public void setRequestMethod(String method) throws Exception {
        this.con.setRequestMethod(method);
    }

    public void addHeader(String key, String value)
    {
        con.setRequestProperty(key, value);
    }

    public void addData(String key, Object value)
    {
        if (this.json == null)
            this.json = new JSONObject();
        this.json.put(key, "\"" + value + "\"");
    }

    public void setUrlParameters(String params)
    {
        this.urlParameters = params;
    }

    public String send() throws Exception
    {
        System.out.println("Connection to " + url);

        String method = con.getRequestMethod();
        if (urlParameters != null)
        {
            this.url = new URL(this.url.toString() + '?' + urlParameters);
            this.con = (HttpURLConnection)this.url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod(method);
        }

        if (json != null) {
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(json.toString());
            wr.close();
        }

        System.out.println("Url : " + url);

        int responseCode = con.getResponseCode();

        System.out.println(url + " response code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        System.out.println(response);

        return response.toString();
    }
}
