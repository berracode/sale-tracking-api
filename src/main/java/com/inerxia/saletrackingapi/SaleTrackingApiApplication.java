package com.inerxia.saletrackingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableTransactionManagement
public class SaleTrackingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleTrackingApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                 .allowedOrigins("http://localhost:4200")
                 .allowedMethods("GET","POST","PUT")
                 .maxAge(3600);
            }

        };
    }
}
