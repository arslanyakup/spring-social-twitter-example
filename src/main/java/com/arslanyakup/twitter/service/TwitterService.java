package com.arslanyakup.twitter.service;

import org.springframework.social.connect.UserProfile;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;

import java.util.List;

/**
 * Created by Arslan on 21.6.2017.
 */
public interface TwitterService {

    public TwitterProfile getUserProfileByUsername(String username);

    public List<TwitterProfile> getFollowerUsersProfile(String username);

    public List<TwitterProfile> getFollowingUsersProfile(String username);

    public TwitterProfile getAuthenticatedUserProfile();

    public void shareFloodTweet(String floodTweetContent);

}