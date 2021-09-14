package com.ws.rest.primenumber.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * PrimeNumberService is used to populate list of prime numbers based on given
 * limit.
 * <p>
 * getPrimeNumbersWithLimit(int limit) will be used to populate prime numbers
 * without multi-threaded environment.
 * <p>
 * getPrimeNumbersMultiThreaded(int limit) will be used to populate prime
 * numbers with parallel stream to get better performance.
 *
 * @author kapilkumar
 */
@Slf4j
public class PrimeNumberServiceImpl implements PrimeNumberService {

    private long timeTakenInMilliSeconds;

    @Override
    public List<Integer> getPrimeNumbersWithLimit(int limit) {
        log.info("PRIME_NUMBER_SERVICE: Finding prime numbers and the limit is {}", limit);
        List<Integer> primeNumbers = new ArrayList<>();
        if (limit > 0) {
            primeNumbers.add(1);

            long start = System.currentTimeMillis();
            IntStream.rangeClosed(2, limit)
                    .filter(this::isPrime)
                    .forEach(primeNumbers::add);
            long finish = System.currentTimeMillis();
            timeTakenInMilliSeconds = finish - start;
        }
        return primeNumbers;
    }

    @Override
    public List<Integer> getPrimeNumbersMultiThreaded(int limit) {
        log.info("PRIME_NUMBER_SERVICE: Finding prime numbers with multi threading implementation and the limit is {}", limit);
        List<Integer> primeNumbers = new ArrayList<>();
        if (limit > 0) {
            primeNumbers.add(1);

            long start = System.currentTimeMillis();
            IntStream.rangeClosed(2, limit)
                    .parallel()
                    .filter(this::isPrime)
                    .forEach(primeNumbers::add);
            long finish = System.currentTimeMillis();
            timeTakenInMilliSeconds = finish - start;
        }
        return primeNumbers;
    }

    private boolean isPrime(int number) {
        return number > 1
                && IntStream.range(2, number).noneMatch(
                index -> number % index == 0);
    }

    @Override
    public long getTimeTaken() {
        return timeTakenInMilliSeconds;
    }

}

