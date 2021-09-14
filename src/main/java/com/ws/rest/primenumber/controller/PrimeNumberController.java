package com.ws.rest.primenumber.controller;

import com.ws.rest.primenumber.model.PrimeNumberRequest;

import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/calculator/")
public interface PrimeNumberController {

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/primeNumbers/{primeNumberLimit}")
    Response primeNumbers(
            @Valid @BeanParam PrimeNumberRequest primeNumberRequest);

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/primeNumbers/multiThreaded/{primeNumberLimit}")
    Response primeNumbersMultiThreaded(
            @Valid @BeanParam PrimeNumberRequest primeNumberRequest);

}
