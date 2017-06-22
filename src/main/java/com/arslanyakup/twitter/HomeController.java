package com.arslanyakup.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Arslan on 20.6.2017.
 */
@Controller
public class HomeController {

    @Autowired
    private Twitter twitter;



}
