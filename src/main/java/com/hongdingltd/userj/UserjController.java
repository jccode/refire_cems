package com.hongdingltd.userj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jcchen on 15-11-25.
 */
@RestController
@RequestMapping("/userj")
public class UserjController {

    @Autowired
    private UserjRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Userj> get() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Userj get(@PathVariable Long id) {
        return repository.findOne(id);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public Userj create(@RequestBody Userj user) {
//        return repository.save(user);
//    }
}
