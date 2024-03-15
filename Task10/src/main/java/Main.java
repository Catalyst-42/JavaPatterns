package Task10.src.main.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        
        Programmer junior = context.getBean("junior", Programmer.class);
        Programmer middle = context.getBean("middle", Programmer.class);
        Programmer senior = context.getBean("senior", Programmer.class);
        
        junior.doCoding();
        middle.doCoding();
        senior.doCoding();

        ((ConfigurableApplicationContext) context).close();
    }
}
