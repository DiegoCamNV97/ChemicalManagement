package com.chemicalmanagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
// Marca este ObjectMapper como el principal
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // Configuración para evitar referencias circulares
        mapper.registerModule(new Hibernate5Module());
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return mapper;
    }
}
