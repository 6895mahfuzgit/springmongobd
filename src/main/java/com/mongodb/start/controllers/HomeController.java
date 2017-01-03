package com.mongodb.start.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 03-Jan-17.
 */
@Controller
public class HomeController {


    public static final String HOME_PAGE_VIEW = "home";

    @RequestMapping("/")
    public String home() {
        return HOME_PAGE_VIEW;
    }
}
