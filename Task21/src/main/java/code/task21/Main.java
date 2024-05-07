package code.task21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(final String[] args) {
        // Mail и Async вызовы для почты
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        
        ShopService service = context.getBean(ShopService.class);
        service.findAllCarts();
        service.findAllItems();
        service.findCartById(4);
        service.findUserItems("UserTwo");
    }
}
