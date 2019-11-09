package com.blink.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Value("${rest.timeout:5}")
    private int REST_TIMEOUT;

    @Bean
    public RestTemplate getRestTemplateWithTimeout() {
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(REST_TIMEOUT)).build();
    }

}
