package org.seoultech.fitnesspotential.global.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExceptionResponse {

    private String errorMessage;
    private String errorCode;

    @Builder
    public ExceptionResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public static class ExceptionResponseBuilder {

        private String errorMessage;
        private String errorCode;

        public ExceptionResponseBuilder httpStatus(HttpStatus httpStatus) {
            this.errorMessage = httpStatus.getReasonPhrase();
            this.errorCode = Integer.toString(httpStatus.value());
            return this;
        }

        public ExceptionResponseBuilder exception(Exception exception) {
            if (exception instanceof MethodArgumentNotValidException) {
                this.errorMessage = ValidationExceptionProcessor.builder()
                        .exception((MethodArgumentNotValidException) exception)
                        .build().toString();
            }
            else {
                this.errorMessage = exception.getMessage();
            }
            return this;
        }
    }
}
