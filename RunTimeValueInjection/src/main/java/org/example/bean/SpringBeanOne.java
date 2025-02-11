package org.example.bean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne implements InitializingBean {
    @Value("dila")
    private String massage;

    public SpringBeanOne() {
        System.out.println("SpringBeanOne Constructor + " + massage);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne afterPropertiesSet + " + massage);
    }
}
