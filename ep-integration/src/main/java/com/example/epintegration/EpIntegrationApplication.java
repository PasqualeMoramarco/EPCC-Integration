package com.example.epintegration;

import com.example.epintegration.service.ElasticPathService;
import com.example.epintegration.service.ElasticPathServiceImpl;
import com.example.epintegration.service.OrderService;
import com.example.epintegration.service.OrderServiceImpl;
import com.example.epintegration.utils.AuthorizationReq;
import com.example.epintegration.utils.HttpReq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EpIntegrationApplication {

    public static void main(String[] args) {

        SpringApplication.run(EpIntegrationApplication.class, args);

    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    @Bean
    public ElasticPathService elasticPathService() {
        return new ElasticPathServiceImpl();
    }

    @Bean
    public AuthorizationReq authorizationReq() {
        return new AuthorizationReq();
    }

    @Bean
    public HttpReq httpReq() {
        return new HttpReq();
    }

}
