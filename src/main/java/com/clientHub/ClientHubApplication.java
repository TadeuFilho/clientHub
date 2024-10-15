package com.clientHub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientHubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientHubApplication.class, args);
    }

}
