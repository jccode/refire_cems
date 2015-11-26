package com.hongdingltd.core.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jcchen on 15-11-26.
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String username;
    private String authority;

    public Authority() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}