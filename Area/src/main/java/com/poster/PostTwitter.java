package com.poster;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class PostTwitter extends APost {

    String consumerKey;
    String consumerSecretKey;
    String accessTokenStr;
    String accessTokenSecretStr;
    Twitter twitter;
    AccessToken accessToken;

    public PostTwitter(String token)
    {
        super(token);

        String[] arr = token.split(":");
        consumerKey = arr[0];
        consumerSecretKey = arr[1];
        accessTokenStr = arr[2];
        accessTokenSecretStr = arr[3];
    }

    @Override
    public boolean connect() {
        System.out.println("CONNECT");
        twitter =  new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecretKey);

        accessToken = new AccessToken(accessTokenStr,
                accessTokenSecretStr);

        twitter.setOAuthAccessToken(accessToken);
        return true;
    }

    @Override
    public void send(String recipient, String api, String data)
    {
        try {
            System.out.println("Send post to Twitter");
            twitter.updateStatus(api + ": " + data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
