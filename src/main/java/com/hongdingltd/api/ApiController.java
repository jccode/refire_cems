package com.hongdingltd.api;

import com.hongdingltd.core.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jcchen on 15-12-6.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User currentUser() {
        // TODO to be implement
        return null;
    }

}
