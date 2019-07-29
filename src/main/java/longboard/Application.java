package longboard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by ArtemParfenov on 12.07.2019.
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"longboard"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        int currentMinute = 0;
        while (true) {
            if (Calendar.getInstance().get(Calendar.MINUTE) != currentMinute) {
                log.info("bip");
                currentMinute = Calendar.getInstance().get(Calendar.MINUTE);
            }
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
