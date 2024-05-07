package code.task18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(final String[] args) {
        // Spring Data JPA репозитории и сервисы
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        context.getBean(ShopService.class).run();
    }
}
