package team.trillion.yamuzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import team.trillion.yamuzip.config.CustomBeanNameGenerator;

@SpringBootApplication
@ComponentScan(nameGenerator = CustomBeanNameGenerator.class)
public class YamuzipApplication {

    public static void main(String[] args) {
        SpringApplication.run(YamuzipApplication.class, args);
    }

}
