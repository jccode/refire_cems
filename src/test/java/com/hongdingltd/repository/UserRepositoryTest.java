package com.hongdingltd.repository;

import com.hongdingltd.RefireCemsApplication;
import com.hongdingltd.core.domain.User;
import com.hongdingltd.core.repository.UserRepository;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by jcchen on 15-12-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RefireCemsApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Test
    public void saveUser() {
        long count = userRepository.count();
        User user = new User();
        user.setUsername("kitty");
        userRepository.save(user);
        assertEquals(userRepository.count(), count+1);
        user.setEnabled(true);
        userRepository.save(user);
        User dbuser = userRepository.findByUsername("kitty");
        assertTrue(dbuser.getEnabled());
        System.out.println(dbuser);
    }
}
