package org.example;

import org.example.bean.SpringBeanOne;
import org.example.bean.SpringBeanTwo;
import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

      /*  SpringBeanOne springBeanOne = context.getBean(SpringBeanOne.class);
        SpringBeanTwo springBeanTwo = context.getBean(SpringBeanTwo.class);*/

     /*   System.out.println("SpringBeanOne: " + springBeanOne);
        System.out.println("SpringBeanTwo: " + springBeanTwo);*/
        context.registerShutdownHook();
    }
}
