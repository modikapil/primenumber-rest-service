package com.ws.rest.primenumber;

import com.ws.rest.primenumber.config.JerseyConfig;
import com.ws.rest.primenumber.service.PrimeNumberService;
import com.ws.rest.primenumber.service.PrimeNumberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ApplicationFactory {

    @Bean
    public PrimeNumberService primeNumberService() {
        return new PrimeNumberServiceImpl();
    }

    @Bean
    public JerseyConfig jerseyConfig() {
        return new JerseyConfig();
    }
}
