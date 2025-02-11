package org.example.config;

import org.example.bean.SpringBeanOne;
import org.example.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.bean")
public class AppConfig2 {
    @Bean
    public SpringBeanTwo getSpringBeanTwo() {
        return new SpringBeanTwo();
    }
}
