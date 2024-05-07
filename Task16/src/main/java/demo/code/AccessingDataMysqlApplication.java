package demo.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
    public class AccessingDataMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
        // OneToMany and ManyToOne
        
        // http://localhost:8080/getitems/1
        // http://localhost:8080/getitems/2
        // http://localhost:8080/getitems/3
        // http://localhost:8080/all
    }
}
