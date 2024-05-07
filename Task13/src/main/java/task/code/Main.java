package task.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		// yaml settings
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		Student student = context.getBean(Student.class);
		student.printStudentDetails();
		context.close();
	}
}
