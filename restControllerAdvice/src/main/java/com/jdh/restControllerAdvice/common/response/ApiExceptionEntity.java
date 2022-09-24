package com.jdh.restControllerAdvice.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiExceptionEntity {
    private String errorCode;
    private String errorMsg;

    @Builder
    public ApiExceptionEntity(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
