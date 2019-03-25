package com.poster;

import com.network.HttpClient;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PostFacebook extends APost {

    private OAuthClientRequest request;
    private String link = "";
    private String access = "";
    private String clientId = "";
    private String clientSecret = "";

    public PostFacebook(String token)
    {
        super(token);

        String[] arr = token.split(":");
        if (arr.length > 1) {
            this.clientId = arr[0];
            this.clientSecret = arr[1];
        }
    }
    @Override
    public boolean connect() {
        try {
            request = OAuthClientRequest
                    .authorizationProvider(OAuthProviderType.FACEBOOK)
                    .setClientId(this.clientId)
                    .setRedirectURI("http://localhost:8080/").setScope("publish_actions")
                    .buildQueryMessage();
            this.link = request.getLocationUri();
        } catch (OAuthSystemException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getLink() {
        return this.link;
    }

    public void setCode(String code) {
        try {
            request = OAuthClientRequest
                    .tokenProvider(OAuthProviderType.FACEBOOK)
                    .setGrantType(GrantType.AUTHORIZATION_CODE)
                    .setClientId(this.clientId)
                    .setClientSecret(this.clientSecret)
                    .setRedirectURI("http://localhost:8080/")
                    .setCode(code)
                    .buildBodyMessage();

            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);

            this.access = oAuthResponse.getAccessToken();
            System.out.println("Access code : " + this.access);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void send(String recipient, String api, String data)
    {
        try {
            HttpClient cl = new HttpClient("https://graph.facebook.com/v2.8/" + recipient + "/feed");

            cl.setRequestMethod("POST");
            cl.setUrlParameters("message=\"" + data.replace("\n"," ").replace(" ","%20") + "\"&access_token=" + this.access);
          //  cl.addData("message", api + ": " + data);
            cl.addData("access_token", this.access);
            //cl.setUrlParameters("access_token=" + token);
            cl.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
