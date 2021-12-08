package com.example.springadvancedtheorie;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringAdvancedTheorieApplication {
    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Filialen").version("1.0.0")
                .description("Toegang tot onze filialen"));
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedTheorieApplication.class, args);
    }

}
