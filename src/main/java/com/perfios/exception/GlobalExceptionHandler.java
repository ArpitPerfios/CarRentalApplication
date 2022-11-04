package com.perfios.exception;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={AppointmentServiceException.class})
    public ResponseEntity<Object> handleAppointmentServiceException(AppointmentServiceException ex, WebRequest request) {
        String errorMessageDescription = ex.getLocalizedMessage();

        if (errorMessageDescription == null) errorMessageDescription = ex.toString();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
        return new ResponseEntity <> (errorMessage,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}