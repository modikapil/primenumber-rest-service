package com.ws.rest.primenumber.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PrimeNumberControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldGetPrimeNumbersUpToAndIncludingNumberProvided() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/v1/calculator/primeNumbers/13").toString(), String.class);
        Assertions.assertTrue(Objects.requireNonNull(response.getBody()).contains("\"primeNumbers\":[1,2,3,5,7,11,13]"));
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void shouldGetPrimeNumbersUpToAndIncludingNumberProvidedWithMultithreading() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/v1/calculator/primeNumbers/multiThreaded/13").toString(), String.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}

