package com.hongdingltd.core.repository;

import com.hongdingltd.core.domain.User;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by jcchen on 15-11-25.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Modifying
    @Query("update User u set u.lastAccessed = current_date where u.username = ?1")
    int updateLastAccessed(String username);
}
