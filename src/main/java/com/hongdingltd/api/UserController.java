package com.hongdingltd.api;

import com.hongdingltd.core.domain.User;
import com.hongdingltd.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jcchen on 15-11-25.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> get() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return repository.findOne(id);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public User create(@RequestBody User user) {
//        return repository.save(user);
//    }
}
