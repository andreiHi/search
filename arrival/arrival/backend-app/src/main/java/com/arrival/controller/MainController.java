package com.arrival.controller;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * SPA hack when run on embedded tomcat.
 * @author Victor Karetko.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/**/{[path:[^\\.]*}")
    public String redirect(HttpServletRequest request) {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }
}
