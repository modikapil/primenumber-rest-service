package com.ws.rest.primenumber.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PrimeNumberRequest {

    @NotNull
    @Min(1)
    @PathParam("primeNumberLimit")
    private String primeNumberLimit;

}
