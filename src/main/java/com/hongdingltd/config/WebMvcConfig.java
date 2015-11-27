package com.hongdingltd.config;

import com.hongdingltd.core.CsrfInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by jcchen on 15-11-27.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private CsrfInterceptor csrfInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
        registry.addInterceptor(csrfInterceptor);
    }
}
