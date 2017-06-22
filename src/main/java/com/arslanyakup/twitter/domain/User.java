package com.arslanyakup.twitter.domain;

/**
 * Created by Arslan on 21.6.2017.
 */
public class User {

    private String username;

    private String floodTweetContent;

    public String getFloodTweetContent() {
        return floodTweetContent;
    }

    public void setFloodTweetContent(String floodTweetContent) {
        this.floodTweetContent = floodTweetContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {
    }
}
