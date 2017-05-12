package vk.dev.inpas;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;

/**
 * Created by vk on 21.04.2017.
 */
public class SomeComponent implements InitializingBean, DisposableBean {

    public void init() {
        System.out.println("<e>");
    }

    public void close() {
        System.out.println("<f>");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("<g>");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("<h>");
    }

    @PreDestroy
    public void preDestr() {
        System.out.println("<predestr comp>");
    }

    public void println() {
        System.out.println("<i>");
    }
}
