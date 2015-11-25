package com.hongdingltd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * Created by jcchen on 15-11-25.
 */
@Controller
public class PageController {

    @RequestMapping(value = {"/", "/home"})
    public String homePage(Map<String, Object> model) {
        model.put("title", "Welcome");
        return "index";
    }
}
