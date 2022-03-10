package com.test.mycode.exceptionHandler;

import com.test.mycode.exception.ExceptionLord;
import com.test.mycode.exception.ExceptionPlanet;
import com.test.mycode.exception.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ExceptionPlanet.class)
    public ResponseEntity<?> exceptionPlanet(ExceptionPlanet exceptionPlanet) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionModel.builder().httpStatus(HttpStatus.NOT_FOUND)
                        .message(exceptionPlanet.getMessage()).build());
    }

    @ExceptionHandler(ExceptionLord.class)
    public ResponseEntity<?> exceptionLord(ExceptionLord exceptionLord) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionModel.builder().httpStatus(HttpStatus.NOT_FOUND)
                        .message(exceptionLord.getMessage()).build());
    }

}
