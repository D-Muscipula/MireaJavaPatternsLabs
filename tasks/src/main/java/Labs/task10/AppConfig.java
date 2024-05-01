package Labs.task10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "junior")
    public Junior junior() {
        return new Junior();
    }

    @Bean(name = "middle")
    public Middle middle() {
        return new Middle();
    }

    @Bean(name = "senior")
    public Senior senior() {
        return new Senior();
    }
}

