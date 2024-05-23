package tasks23_24.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(basePackages = "tasks23_24.repository")
@EnableAsync
@EnableScheduling
public class AppConfig {
}
