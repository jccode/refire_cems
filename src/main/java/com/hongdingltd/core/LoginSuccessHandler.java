package com.hongdingltd.core;

import com.hongdingltd.core.repository.UserRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jcchen on 15-11-26.
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements ApplicationContextAware {

//    @Autowired
//    private UserRepository repository;

    @Autowired
    ApplicationContext ctx;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        UserRepository repository = (UserRepository) ctx.getBean("UserRepository");
        repository.updateLastAccessed(authentication.getName());
        super.onAuthenticationSuccess(request, response, authentication);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }
}
