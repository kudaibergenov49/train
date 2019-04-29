package ru.tinkoff.train.train.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.train.train.model.Train;
import ru.tinkoff.train.train.repository.TrainRepository;

@Configuration
public class LoadDatabase {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TrainRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Train("100",3)));
            log.info("Preloading " + repository.save(new Train("001",3)));
        };
    }
}
