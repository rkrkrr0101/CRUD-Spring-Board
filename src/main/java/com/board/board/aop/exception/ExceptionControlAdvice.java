package com.board.board.aop.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControlAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentHandler(Exception e){
        return "Illegal id";
    }
    @ExceptionHandler(IllegalStateException.class)
    public String illegalStateHandler(Exception e){
        e.printStackTrace();
        return "Illegal state";

    }
}
