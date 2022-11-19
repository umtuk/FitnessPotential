package org.seoultech.fitnesspotential.global.exception;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class ValidationExceptionProcessor {

    private Map<String, String> fieldErrorMap;

    @Builder
    public ValidationExceptionProcessor(MethodArgumentNotValidException exception) {
        fieldErrorMap = new HashMap<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

    @Override
    public String toString() {
        return fieldErrorMap.toString();
    }
}
