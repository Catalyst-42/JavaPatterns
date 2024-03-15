package Task12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length != 2) {
            System.err.println("Not enough arguments");
            System.exit(0);
        }
        
        FileHasher fh = new FileHasher();
        fh.setUP(args);
        fh.info();

        try {
            fh.hash();
        } catch (Exception e) {
            System.err.println("No such files");
        }

        System.exit(0);
    }

    // ... Task12/file1.txt Task12/file2.txt
}
