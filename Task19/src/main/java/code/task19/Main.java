package code.task19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(final String[] args) {
        // Logback и логирование во всех методах
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        context.getBean(ShopService.class).run();
    }
}
