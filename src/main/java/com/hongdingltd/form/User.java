package com.hongdingltd.form;

import javax.validation.constraints.*;

/**
 * Created by jcchen on 15-11-30.
 */
public class User {

    @Size(min = 6, max = 30)
    private String username;

    @Pattern(regexp = ".*{6,20}")
    private String password;

    @Min(0)
    @Max(100)
    private Integer age;

    private Integer gender;
}
