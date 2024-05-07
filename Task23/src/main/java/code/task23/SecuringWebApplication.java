package code.task23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuringWebApplication {
	public static void main(String[] args) throws Throwable {
		// Spring Security
		SpringApplication.run(SecuringWebApplication.class, args);
	}
}
