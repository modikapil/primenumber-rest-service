package com.ws.rest.primenumber.mapper;

import com.ws.rest.primenumber.model.ErrorHeader;
import com.ws.rest.primenumber.model.JSRError;
import org.apache.http.HttpStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JSRConstraintViolationExceptionMapper implements
        ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        ErrorHeader errorHeader = new ErrorHeader();
        exception.getConstraintViolations()
                .stream()
                .forEach(p -> buildError(p, errorHeader));

        return Response.ok(errorHeader).status(HttpStatus.SC_BAD_REQUEST)
                .type(MediaType.APPLICATION_JSON).build();
    }

    private void buildError(ConstraintViolation<?> voilation,
                            ErrorHeader errorHeader) {
        if (voilation.getMessageTemplate().contains(
                "javax.validation.constraints.NotNull.message")) {
            JSRError error = new JSRError(
                    String.valueOf(HttpStatus.SC_BAD_REQUEST),
                    voilation.getPropertyPath() + " shouldn't be null");
            errorHeader.getErrors().add(error);
        } else if (voilation.getMessageTemplate().contains(
                "javax.validation.constraints.Size.message")) {
            JSRError error = new JSRError(
                    String.valueOf(HttpStatus.SC_BAD_REQUEST),
                    voilation.getPropertyPath()
                            + " should contain correct size");
            errorHeader.getErrors().add(error);
        } else if (voilation.getMessageTemplate().contains(
                "javax.validation.constraints.Min.message")) {
            JSRError error = new JSRError(
                    String.valueOf(HttpStatus.SC_BAD_REQUEST),
                    voilation.getPropertyPath()
                            + " should contain correct min value");
            errorHeader.getErrors().add(error);
        } else {
            JSRError error = new JSRError(
                    String.valueOf(HttpStatus.SC_BAD_REQUEST),
                    voilation.getPropertyPath() + " something is wrong");
            errorHeader.getErrors().add(error);
        }

    }

}

