package com.ws.rest.primenumber.model;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

public class ErrorHeader {

    @Valid
    private List<JSRError> errors;

    public List<JSRError> getErrors() {
        if (errors != null) {
            return errors;
        }
        return errors = new ArrayList<>();
    }

}
