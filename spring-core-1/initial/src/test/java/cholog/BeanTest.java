package cholog;

import static cholog.utils.ContextUtils.getApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

import cholog.bean.AutowiredBean;
import cholog.bean.SpringBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

public class BeanTest {

    @Test
    void registerBean() {
        ApplicationContext context = getApplicationContext();
        SpringBean springBean = context.getBean("springBean", SpringBean.class);
        assertThat(springBean).isNotNull();
        assertThat(springBean.hello()).isEqualTo("Hello");
    }

    @Test
    void autowiredBean() {
        ApplicationContext context = getApplicationContext();
        AutowiredBean autowiredBean = context.getBean("autowiredBean", AutowiredBean.class);
        assertThat(autowiredBean.sayHello()).isEqualTo("Hello");
    }
}
