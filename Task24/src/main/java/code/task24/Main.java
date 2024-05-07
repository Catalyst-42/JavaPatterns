package code.task24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    // Модульное тестирование
    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        context.getBean(ShopService.class).run();
        
        // ./gradlew test
    }
}
