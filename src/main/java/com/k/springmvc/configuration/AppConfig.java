package com.k.springmvc.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.k.springmvc")
@EnableWebMvc
public class AppConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setViewClass(JstlView.class);
        irvr.setSuffix(".jsp");
        irvr.setPrefix("/WEB-INF/views/");
        return irvr;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        return messageSource;
    }
}
