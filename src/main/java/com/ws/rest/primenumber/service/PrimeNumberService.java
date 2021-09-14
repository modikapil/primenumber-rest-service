package com.ws.rest.primenumber.service;

import java.util.List;

public interface PrimeNumberService {

    List<Integer> getPrimeNumbersWithLimit(int limit);

    List<Integer> getPrimeNumbersMultiThreaded(int limit);

    long getTimeTaken();

}
