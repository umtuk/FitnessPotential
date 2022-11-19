package org.seoultech.fitnesspotential.global.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionResponseEntity extends ResponseEntity<ExceptionResponse> {

    public ExceptionResponseEntity(ExceptionResponse body, HttpStatus status) {
        super(body, status);
    }

    @Builder
    public ExceptionResponseEntity(Exception exception, HttpStatus httpStatus) {
        this(
                ExceptionResponse.builder()
                        .httpStatus(httpStatus)
                        .exception(exception)
                        .build(),
                httpStatus
        );
    }
}
