package group.Task11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements HealthIndicator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public Health health() {
        return Health.up().build();
    }
}

// java -jar '/Users/control/Desktop/Extension/JavaPatterns/Task11/build/libs/YaWell.jar'
// http://localhost:8080/actuator/health
