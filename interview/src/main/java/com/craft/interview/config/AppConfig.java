package com.craft.interview.config;

// import java.util.List;

// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;

// import com.craft.interview.entity.PEntity;

// import io.microsphere.spring.config.env.support.JsonPropertySourceFactory;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
