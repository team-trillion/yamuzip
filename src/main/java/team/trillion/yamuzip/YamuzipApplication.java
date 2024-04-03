package team.trillion.yamuzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import team.trillion.yamuzip.config.CustomBeanNameGenerator;

@EnableScheduling
@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class YamuzipApplication {

    public static void main(String[] args) {
        SpringApplication.run(YamuzipApplication.class, args);
    }

}
