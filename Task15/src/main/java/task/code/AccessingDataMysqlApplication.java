package task.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMysqlApplication {
  public static void main(String[] args) {
    SpringApplication.run(AccessingDataMysqlApplication.class, args);
    // MySQL хранение всего в базе данных
    // http://localhost:8080/set?name=AnotherName&email=stamp@pmats.com
    // http://localhost:8080/all
  }
}
