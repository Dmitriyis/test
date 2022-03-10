package com.test.mycode.exception.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ExceptionModel {

    private String message;

    private HttpStatus httpStatus;
}
