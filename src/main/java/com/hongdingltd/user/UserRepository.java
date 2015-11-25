package com.hongdingltd.user;

import org.springframework.data.repository.CrudRepository;


/**
 * Created by jcchen on 15-11-25.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
