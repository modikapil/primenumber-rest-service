package com.ws.rest.primenumber.controller;

import com.ws.rest.primenumber.model.PrimeNumberRequest;
import com.ws.rest.primenumber.model.PrimeNumberResponse;
import com.ws.rest.primenumber.service.PrimeNumberService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
public class PrimeNumberControllerImpl implements PrimeNumberController {

    @Autowired
    private PrimeNumberService primeNumberService;

    @Override
    public Response primeNumbers(PrimeNumberRequest primeNumberRequest) {
        return buildControllerResponse(buildPrimeNumberResponse(Integer
                .parseInt(primeNumberRequest.getPrimeNumberLimit())));
    }

    @Override
    public Response primeNumbersMultiThreaded(
            PrimeNumberRequest primeNumberRequest) {
        return buildControllerResponse(buildPrimeNumberMultiThreadedResponse(Integer
                .parseInt(primeNumberRequest.getPrimeNumberLimit())));
    }

    private PrimeNumberResponse buildPrimeNumberResponse(int limit) {
        return new PrimeNumberResponse(
                primeNumberService.getPrimeNumbersWithLimit(limit),
                primeNumberService.getTimeTaken());
    }

    private PrimeNumberResponse buildPrimeNumberMultiThreadedResponse(int limit) {
        return new PrimeNumberResponse(
                primeNumberService.getPrimeNumbersMultiThreaded(limit),
                primeNumberService.getTimeTaken());
    }

    private Response buildControllerResponse(
            PrimeNumberResponse primeNumberResponse) {
        return Response.status(HttpStatus.SC_OK).entity(primeNumberResponse)
                .type(MediaType.APPLICATION_JSON).build();
    }

}
