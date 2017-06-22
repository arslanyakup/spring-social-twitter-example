package com.arslanyakup.twitter.controller;

import com.arslanyakup.twitter.domain.User;
import com.arslanyakup.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arslan on 21.6.2017.
 */
@Controller
@SessionAttributes(value = "{user}")
public class TwitterController {

    private Twitter twitter;
    private TwitterService twitterService;

    @ModelAttribute("user")
    public void ınitializeuser(Model model){
        User user=new User();
        model.addAttribute("user",user);
    }

    @Autowired
    public TwitterController(Twitter twitter, TwitterService twitterService) {
        this.twitter = twitter;
        this.twitterService = twitterService;
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/shareflood",method = RequestMethod.GET)
    public String shareFlood(Model model){
        model.addAttribute("profile",twitterService.getAuthenticatedUserProfile());
        return "shareflood";
    }

    @RequestMapping(value ="/sharefloodtweet",method = RequestMethod.GET)
    public String shareFloodTweet(@ModelAttribute("user") User user,Model model){
        twitterService.shareFloodTweet(user.getFloodTweetContent());
        model.addAttribute("profile",twitterService.getAuthenticatedUserProfile());
        return "user";
    }


    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllTweets(Model model, @ModelAttribute("user") User user){
        model.addAttribute("profile",twitterService.getUserProfileByUsername(user.getUsername()));
        model.addAttribute("followers",twitterService.getFollowerUsersProfile(user.getUsername()));
        model.addAttribute("friends",twitterService.getFollowingUsersProfile(user.getUsername()));
        return "user";
    }

}
