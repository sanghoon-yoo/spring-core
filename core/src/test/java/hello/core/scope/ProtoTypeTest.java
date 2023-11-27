package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoTypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean PrototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean PrototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("PrototypeBean1 = " + PrototypeBean1);
        System.out.println("PrototypeBean2 = " + PrototypeBean2);
        assertThat(PrototypeBean1).isNotSameAs(PrototypeBean2);

        ac.close();

    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        void init() {
            System.out.println("Prototype Bean init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("Prototype Bean destroy");
        }

    }
}
