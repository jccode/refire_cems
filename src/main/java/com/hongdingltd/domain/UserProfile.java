package com.hongdingltd.domain;

import com.hongdingltd.core.domain.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jcchen on 15-11-30.
 */
@Entity
@Table(name = "users_profile")
public class UserProfile implements Serializable {

    public enum Gender {
        MALE, FEMALE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String username;

    private String fullname;

    @Enumerated
    private Gender gender;

    private Integer age;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = true, updatable = true)
    private User user;

    public UserProfile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public String getUsername() {
//        return user.getUsername();
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
//                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
