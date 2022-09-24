package com.jdh.restControllerAdvice.controller;

import com.jdh.restControllerAdvice.common.enums.ExceptionEnum;
import com.jdh.restControllerAdvice.common.response.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

@RestController
public class TestExceptionController {

    @GetMapping("/api-exception")
    public void throwApiException() {
        throw new ApiException(ExceptionEnum.RUNTIME_EXCEPTION);
    }

    @GetMapping("/runtime")
    public void throwRuntimeException() {
        throw new RuntimeException("test runtime exception");
    }

    @GetMapping("/access-denied")
    public void throwAccessDeniedException() throws AccessDeniedException {
        throw new AccessDeniedException("test access denied exception");
    }

    @GetMapping("/no-such-element")
    public void throwNoSuchElementException() {
        throw new NoSuchElementException("test no such element exception");
    }

    @GetMapping("/bad-request")
    public void throwBadRequestException() {
        throw new ApiException(ExceptionEnum.BAD_REQUEST);
    }

    @GetMapping("/forbidden")
    public void throwForbiddenException() {
        throw new ApiException(ExceptionEnum.FORBIDDEN);
    }

    @GetMapping("/exception")
    public void throwException() throws Exception {
        throw new Exception("test exception");
    }

    @GetMapping("/ok")
    public void ok() {
        System.out.println("ok");
    }
}
