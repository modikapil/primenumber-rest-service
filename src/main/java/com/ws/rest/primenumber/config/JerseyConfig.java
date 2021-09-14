package com.ws.rest.primenumber.config;

import com.ws.rest.primenumber.controller.PrimeNumberControllerImpl;
import com.ws.rest.primenumber.mapper.JSRConstraintViolationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(PrimeNumberControllerImpl.class);
        register(JSRConstraintViolationExceptionMapper.class);
    }

}
