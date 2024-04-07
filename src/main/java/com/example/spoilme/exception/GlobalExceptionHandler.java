package com.example.spoilme.exception;

import com.example.spoilme.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        log.info("其他异常{}", ex.getMessage());
        log.info("其他异常{}", ex.getCause().getMessage());
        return Result.error("操作失败");
    }

}
