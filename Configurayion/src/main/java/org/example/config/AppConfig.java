package org.example.config;

import org.example.bean.SpringBeanOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig2.class)
public class AppConfig {
    @Bean
    public SpringBeanOne getSpringBeanOne() {
        return new SpringBeanOne();
    }

}
