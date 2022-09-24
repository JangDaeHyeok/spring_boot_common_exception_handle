package com.jdh.restControllerAdvice.common.response;

import com.jdh.restControllerAdvice.common.enums.ExceptionEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionAdvice {
    // custom exception
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, ApiException e) {
        // e.printStackTrace();
        return ResponseEntity
                .status(e.getError().getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(e.getError().getCode())
                        .errorMsg(e.getError().getMessage())
                        .build());
    }

    // runtime(checked) exception
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, final RuntimeException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.RUNTIME_EXCEPTION.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ExceptionEnum.RUNTIME_EXCEPTION.getCode())
                        .errorMsg(e.getMessage())
                        .build());
    }

    // access denied exception
    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, final AccessDeniedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.ACCESS_DENIED.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ExceptionEnum.ACCESS_DENIED.getCode())
                        .errorMsg(ExceptionEnum.ACCESS_DENIED.getMessage())
                        .build());
    }

    // access denied exception
    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, final NoSuchElementException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.NO_SUCH_ELEMENT.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ExceptionEnum.NO_SUCH_ELEMENT.getCode())
                        .errorMsg(e.getMessage())
                        .build());
    }

    // bad request exception
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, final HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.METHOD_NOT_ALLOWED.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ExceptionEnum.METHOD_NOT_ALLOWED.getCode())
                        .errorMsg(ExceptionEnum.METHOD_NOT_ALLOWED.getMessage())
                        .build());
    }

    // unchecked exception
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(HttpServletRequest req, final Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(ExceptionEnum.INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode())
                        .errorMsg(e.getMessage())
                        .build());
    }
}
