package com.hongdingltd.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by jcchen on 15-11-25.
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    UserRepository repository

    @RequestMapping(method = [RequestMethod.GET])
    def get(Long id) {
        id ? repository.findOne(id) : repository.findAll()
    }

    @RequestMapping(method = [RequestMethod.POST])
    def create(@RequestBody User user) {
        repository.save user
        user
    }
}
