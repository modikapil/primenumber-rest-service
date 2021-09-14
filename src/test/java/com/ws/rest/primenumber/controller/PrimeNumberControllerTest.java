package com.ws.rest.primenumber.controller;

import com.ws.rest.primenumber.model.PrimeNumberRequest;
import com.ws.rest.primenumber.model.PrimeNumberResponse;
import com.ws.rest.primenumber.service.PrimeNumberService;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PrimeNumberControllerTest {

    private PrimeNumberRequest primeNumberRequest;

    @Mock
    private PrimeNumberService primeNumberService;

    @InjectMocks
    private final PrimeNumberController underTest = new PrimeNumberControllerImpl();

    List<Integer> primeNumbers = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19,
            23, 29, 31, 37, 41, 43, 47);

    @BeforeEach
    public void setUp() {
        populatePrimeNumberRequest();
    }

    @Test
    public void shouldBuildResponse() {
        buildMock();
        Response response = underTest.primeNumbers(primeNumberRequest);

        PrimeNumberResponse primeNumberResponse = (PrimeNumberResponse) response
                .getEntity();

        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatus());
        Assertions.assertEquals(16, primeNumberResponse.getPrimeNumbers().size());
        Assertions.assertEquals(1L, primeNumberResponse.getTimeTakenInMilliSeconds());
    }

    @Test
    public void shouldBuildResponseWithMultiThreaded() {
        buildMockMultiThreaded();
        Response response = underTest
                .primeNumbersMultiThreaded(primeNumberRequest);

        PrimeNumberResponse primeNumberResponse = (PrimeNumberResponse) response
                .getEntity();

        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatus());
        Assertions.assertEquals(16, primeNumberResponse.getPrimeNumbers().size());
        Assertions.assertEquals(1L, primeNumberResponse.getTimeTakenInMilliSeconds());
    }

    private void populatePrimeNumberRequest() {
        primeNumberRequest = new PrimeNumberRequest("50");
    }

    private void buildMock() {
        when(primeNumberService.getPrimeNumbersWithLimit(50)).thenReturn(
                primeNumbers);
        when(primeNumberService.getTimeTaken()).thenReturn(new Long(1));
    }

    private void buildMockMultiThreaded() {
        when(primeNumberService.getPrimeNumbersMultiThreaded(50)).thenReturn(
                primeNumbers);
        when(primeNumberService.getTimeTaken()).thenReturn(new Long(1));
    }

}
