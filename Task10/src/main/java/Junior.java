package Task10.src.main.java;

import org.springframework.stereotype.Component;

@Component("junior")
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Junior is coding...");
    }
}
