package com.hongdingltd.user;

import com.hongdingltd.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by jcchen on 15-11-25.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
