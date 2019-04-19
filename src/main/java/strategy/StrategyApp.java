package strategy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import strategy.repositiry.ArrayRepository;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = ArrayRepository.class)
@PropertySource("classpath:application.properties")
public class StrategyApp {
    public static void main(String[] args) {
        SpringApplication.run(StrategyApp.class, args);
    }
}
