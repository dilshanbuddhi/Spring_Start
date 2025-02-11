package org.example;

import org.example.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        /*Map<String , String> map = System.getenv();
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }*/

        context.registerShutdownHook();
    }
}
