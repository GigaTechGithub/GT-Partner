package com.gt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(new SessionListener());
    }
}
