package org.example.bean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne implements InitializingBean {
    @Value("${os.name}")
    private String massage;
    @Value("${db.user}")
    private String  user;
    @Value("${db.password}")
    private String password;

    public SpringBeanOne() {
        System.out.println("SpringBeanOne Constructor + " + massage);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SpringBeanOne afterPropertiesSet + " + massage);
        System.out.println("userName = " + user + ", password = " + password);
    }
}
