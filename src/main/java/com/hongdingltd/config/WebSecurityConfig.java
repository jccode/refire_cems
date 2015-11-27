package com.hongdingltd.config;

import com.hongdingltd.core.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


/**
 * Created by jcchen on 15-11-25.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/webjars/**").permitAll()
                //.antMatchers("/", "/user/*", "/greeting").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/dba/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").successHandler(loginSuccessHandler).permitAll()
                .and().csrf()
                .and().rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(648000) // half year.
                .and().logout().invalidateHttpSession(true).deleteCookies("remember-me").permitAll()
                .and().exceptionHandling().accessDeniedPage("/access_denied");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
        auth.jdbcAuthentication().dataSource(dataSource)
//                .withDefaultSchema()
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}

