package com.arslanyakup.twitter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.*;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import org.springframework.social.twitter.security.TwitterAuthenticationService;
import org.springframework.stereotype.Component;

/**
 * Created by Arslan on 21.6.2017.
 */
@Configuration
@Component
@PropertySource("classpath:application.properties")
public class TwitterConfiguration {


    @Autowired
    private Environment environment;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator(){
        ConnectionFactoryRegistry connectionFactoryRegistry=new ConnectionFactoryRegistry();
        connectionFactoryRegistry.addConnectionFactory(new TwitterConnectionFactory(
        environment.getProperty("twitter.consumerKey"),
        environment.getProperty("twitter.consumerSecret")));
        return connectionFactoryRegistry;
    }

    @Bean
    public Twitter getTwitterTemplate(){
        String consumerKey=environment.getProperty("twitter.consumerKey");
        String consumerSecret=environment.getProperty("twitter.consumerSecret");
        String accessToken=environment.getProperty("twitter.accessToken");
        String accessTokenSecret=environment.getProperty("twitter.accessTokenSecret");
        TwitterTemplate twitterTemplate=new TwitterTemplate(consumerKey,consumerSecret,accessToken,accessTokenSecret);
        return twitterTemplate;
    }



}
