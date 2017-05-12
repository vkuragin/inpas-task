package vk.dev.inpas;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Created by vk on 21.04.2017.
 */
public class SomeService implements InitializingBean, DisposableBean {

    private final SomeComponent component;

    public SomeService(SomeComponent component) {
        this.component = component;
    }


    public void init() {
        System.out.println("<a>");
    }

    public void close() {
        System.out.println("<b>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("<c>");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("<d>");
    }

    public void call() {
        component.println();
    }
}