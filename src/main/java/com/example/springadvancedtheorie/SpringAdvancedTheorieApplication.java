package com.example.springadvancedtheorie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringAdvancedTheorieApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdvancedTheorieApplication.class, args);
    }

}
