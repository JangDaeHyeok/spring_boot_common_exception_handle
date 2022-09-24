package com.jdh.restControllerAdvice.common.response;

import com.jdh.restControllerAdvice.common.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private ExceptionEnum error;

    public ApiException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
