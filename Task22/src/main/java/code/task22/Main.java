package code.task22;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Main {
    // JMX и Scheduler
    public static void main(final String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("code.task22:type=JMXController");
        JMXController mbean = context.getBean(JMXController.class);
        mbs.registerMBean(mbean, name);

        // jconsole
    }
}
