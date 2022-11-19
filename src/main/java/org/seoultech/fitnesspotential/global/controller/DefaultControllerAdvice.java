package org.seoultech.fitnesspotential.global.controller;

import org.seoultech.fitnesspotential.global.exception.ExceptionResponse;
import org.seoultech.fitnesspotential.global.exception.ExceptionResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler({ IllegalArgumentException.class, })
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException exception) {
        return ExceptionResponseEntity.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .exception(exception)
                .build();
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class, })
    public ResponseEntity<ExceptionResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        return ExceptionResponseEntity.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .exception(exception)
                .build();
    }
}
