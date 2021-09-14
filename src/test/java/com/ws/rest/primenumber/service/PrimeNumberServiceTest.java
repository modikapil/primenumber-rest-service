package com.ws.rest.primenumber.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeNumberServiceTest {

    private PrimeNumberService underTest;

    @BeforeEach
    public void setUp() {
        underTest = new PrimeNumberServiceImpl();
    }

    @Test
    public void shouldGetPrimeNumbersWithValidLimit() {
        List<Integer> primeNumbers = underTest.getPrimeNumbersWithLimit(50);
        assertEquals(16, primeNumbers.size());
    }

    @Test
    public void shouldNotGetPrimeNumbersWithInValidLimit() {
        List<Integer> primeNumbers = underTest.getPrimeNumbersWithLimit(0);
        assertEquals(0, primeNumbers.size());
    }

    @Test
    public void shouldNotGetPrimeNumbersMultiThreaded() {
        List<Integer> primeNumbers = underTest.getPrimeNumbersMultiThreaded(0);
        assertEquals(0, primeNumbers.size());
    }

    @Test
    public void shouldGetOnlyOnePrimeNumber() {
        List<Integer> primeNumbers = underTest.getPrimeNumbersWithLimit(1);
        assertEquals(1, primeNumbers.size());
        assertEquals(1, primeNumbers.get(0));
    }

    @Test
    public void shouldGetTimeTakenInMilliSeconds() {
        underTest.getPrimeNumbersWithLimit(5000);
        Assertions.assertTrue(underTest.getTimeTaken() > 0);
    }

    @Test
    public void shouldGetBetterPerformanceInMultiThreadedAlgo() {
        underTest.getPrimeNumbersWithLimit(100000);
        long timeWithoutMultiThreaded = underTest.getTimeTaken();
        underTest.getPrimeNumbersMultiThreaded(100000);
        long timeWithMultiThreaded = underTest.getTimeTaken();

        Assertions.assertTrue(timeWithMultiThreaded < timeWithoutMultiThreaded);
    }

}

