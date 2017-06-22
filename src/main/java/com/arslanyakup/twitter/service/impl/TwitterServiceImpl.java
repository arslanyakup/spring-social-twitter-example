package com.arslanyakup.twitter.service.impl;

import com.arslanyakup.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arslan on 21.6.2017.
 */
@Service
public class TwitterServiceImpl implements TwitterService {

    private Twitter twitter;

    @Autowired
    public TwitterServiceImpl(Twitter twitter) {
        this.twitter = twitter;
    }

    public TwitterProfile getUserProfileByUsername(String username) {
        return twitter.userOperations().getUserProfile(username);
    }

    public CursoredList<TwitterProfile> getFollowerUsersProfile(String username) {
        CursoredList<TwitterProfile> profiles=twitter.friendOperations().getFollowers(username);
        return profiles;
    }

    public List<TwitterProfile> getFollowingUsersProfile(String username) {
        return twitter.friendOperations().getFriends(username);
    }

    public TwitterProfile getAuthenticatedUserProfile() {
        return twitter.userOperations().getUserProfile();
    }
    public void shareFloodTweet(String floodTweetContent) {
        int start=0,end=0;
        String tweet;
        List<String> tweetList=new ArrayList<String>();
        char[] charArray=floodTweetContent.toCharArray();
        double tweetCount=Math.round(((double)(floodTweetContent.length())/140)+0.5);

        for(char c:charArray){
            if (c=='.'){
                if (end>=start+120 && end<=start+140){
                    if (tweetList.size()==0){
                        tweet=floodTweetContent.substring(start,end);
                        tweetList.add("("+tweetList.size()+") "+tweet+"++");
                    }
                    else{
                        tweet=floodTweetContent.substring(start+1,end);
                        tweetList.add("("+tweetList.size()+") "+tweet+"++");

                    }
                    start=end;
                }
            }
            if (c==' '){
                if (end>=start+120 && end<=start+140){
                    if (tweetList.size()==0){
                        tweet=floodTweetContent.substring(start,end);
                        tweetList.add("("+tweetList.size()+") "+tweet+"++");
                    }
                    else{
                        tweet=floodTweetContent.substring(start+1,end);
                        tweetList.add("("+tweetList.size()+") "+tweet+"++");
                    }
                    start=end;
                }
            }
            if (end==floodTweetContent.length()-1){
                tweet=floodTweetContent.substring(start+1,end);
                tweetList.add("("+tweetList.size()+") "+tweet+".");
            }
            end++;
        }

        for(String s:tweetList){
            twitter.timelineOperations().updateStatus(s);
        }
    }
}