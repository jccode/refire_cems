package com.hongdingltd.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by jcchen on 15-11-30.
 */
public class User {

    @Size(min = 6, max = 30)
    private String username;

    @Pattern(regexp = "")
    private String password;
}
