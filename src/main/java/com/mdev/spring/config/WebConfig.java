package com.mdev.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/indexTeacher").setViewName("homeTeacher");
        registry.addViewController("/indexStudent").setViewName("homeStudent");
        //registry.addViewController("/shipper_home").setViewName("shipper_home");
    }
}
