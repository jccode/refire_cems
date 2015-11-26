package com.hongdingltd.core;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by jcchen on 15-11-26.
 */
public class SysUtil {

    public static String getPrinciple() {
        String username = null;
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principle instanceof UserDetails) {
            username = ((UserDetails)principle).getUsername();
        } else {
            username = principle.toString();
        }
        return username;
    }
}
