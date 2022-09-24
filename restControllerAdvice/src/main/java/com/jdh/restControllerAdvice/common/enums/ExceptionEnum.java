package com.jdh.restControllerAdvice.common.enums;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "E0001")
    , INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E0002")
    , ACCESS_DENIED(HttpStatus.UNAUTHORIZED, "E0003", "인증되지 않은 사용자입니다.")
    , NO_SUCH_ELEMENT(HttpStatus.INTERNAL_SERVER_ERROR, "E0004")
    , BAD_REQUEST(HttpStatus.BAD_REQUEST, "E0005", "필수 요청 변수가 누락되었습니다.")
    , METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E0006", "요청 메소드를 확인해주세요.")

    , FORBIDDEN(HttpStatus.FORBIDDEN, "S0001", "권한이 없습니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
