package vk.dev.inpas;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vk on 21.04.2017.
 */
public class Main {
    public static void main(String... args) {

        ConfigurableApplicationContext appCtx =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        SomeService service = appCtx.getBean(SomeService.class);
        service.call();

        appCtx.close();

    }
}
