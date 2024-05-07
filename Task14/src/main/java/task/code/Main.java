package task.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // Использование контроллеров и выдача страницы
        
        // http://localhost:8080/home
        // http://localhost:8080/set/patient?firstName=Fuflick&lastName=Clawenstain&position=Azkaban
        // http://localhost:8080/get/patient
	}
}
