package Task10.src.main.java;

import org.springframework.stereotype.Component;

@Component("middle")
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Middle is coding...");
    }
}
