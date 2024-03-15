package Task10.src.main.java;

import org.springframework.stereotype.Component;

@Component("senior")
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("Senior is coding...");
    }
}
