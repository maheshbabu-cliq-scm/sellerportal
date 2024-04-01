package com.sellerportal.configuration;

import org.apache.myfaces.webapp.StartupServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
	
	@Bean
    public ServletListenerRegistrationBean<StartupServletContextListener> myfacesListener() {
        return new ServletListenerRegistrationBean<>(new StartupServletContextListener());
    }

}
