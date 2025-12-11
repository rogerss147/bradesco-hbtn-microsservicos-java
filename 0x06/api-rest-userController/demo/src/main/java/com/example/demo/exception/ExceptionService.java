package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserIdException err) {
        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered ID " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNameException err) {
        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered USERNAME " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(CPFException err) {
        UserErrorResponse response = new UserErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "You have entered CPF " + err.getMessage() + " invalid.");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
