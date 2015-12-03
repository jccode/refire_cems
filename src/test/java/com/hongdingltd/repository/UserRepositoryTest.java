package com.hongdingltd.repository;

import com.google.common.collect.Sets;
import com.hongdingltd.RefireCemsApplication;
import com.hongdingltd.core.domain.Authority;
import com.hongdingltd.core.domain.User;
import com.hongdingltd.core.repository.AuthorityRepository;
import com.hongdingltd.core.repository.UserRepository;
import com.hongdingltd.domain.UserProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jcchen on 15-12-2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RefireCemsApplication.class)
@WebAppConfiguration
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

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

    @Test
    public void saveUserWithAuthorities() {
        long authoritiesCount = authorityRepository.count();
        System.out.println(authoritiesCount);
        User user = new User();
        user.setUsername("tom");

        Authority authority = new Authority();
        authority.setAuthority("ROLE_TEST");
        authority.setUsername(user.getUsername());
        Set<Authority> authorities = Sets.newHashSet(authority);

        user.setAuthorities(authorities);
        userRepository.save(user);
        assertEquals(authorityRepository.count(), authoritiesCount+1);

        Authority dbAuthority = authorityRepository.findByUsername("tom");
        System.out.println(dbAuthority.getUser());
        assertNotNull(dbAuthority);

        // delete
        userRepository.delete(user);
        assertEquals(authorityRepository.count(), authoritiesCount);
    }

    @Test
    @Transactional
    public void userProfile() {
        long count = userProfileRepository.count();

        String username = "akka";
        UserProfile userProfile = new UserProfile();
        userProfile.setFullname("Hello Kitty");
//        userProfile.setUsername(username);
        userProfile.setGender(UserProfile.Gender.MALE);
        userProfile.setAge(15);

        User user = new User();
        user.setUsername(username);
        user.setPassword("123456");

        userProfile.setUser(user);
        userProfileRepository.save(userProfile);

        assertEquals(userProfileRepository.count(), count+1);

        UserProfile dbUserProfile = userProfileRepository.findByUserUsername(username);
        System.out.println(dbUserProfile);
        System.out.println(dbUserProfile.getUser());

        User dbUser = userRepository.findByUsername(username);
        System.out.println(dbUser);
        System.out.println(dbUser.getProfile());

        assertEquals(dbUserProfile.getUser().getId(), dbUser.getId());
    }
}
