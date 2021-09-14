package com.ws.rest.primenumber.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class PrimeNumberResponse {

    @NotNull
    private final List<Integer> primeNumbers;

    @NotNull
    private final long timeTakenInMilliSeconds;

    @JsonCreator
    public PrimeNumberResponse(
            @JsonProperty(value = "primeNumbers") List<Integer> primeNumbers,
            @JsonProperty(value = "timeTakenInMilliSeconds") long timeTakenInMilliSeconds) {
        this.primeNumbers = primeNumbers;
        this.timeTakenInMilliSeconds = timeTakenInMilliSeconds;
    }

}
