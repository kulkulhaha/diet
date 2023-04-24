package actual.rediet.config;

import jakarta.persistence.EntityManager;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.UUID;

@AutoConfiguration
public class BaseConfig {
    @Bean
    public AuditorAware<String> auditorProvider(){
        return ()-> Optional.of(UUID.randomUUID().toString());
    }

}
