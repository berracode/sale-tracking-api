package com.inerxia.saletrackingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SaleTrackingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleTrackingApiApplication.class, args);
    }

}
