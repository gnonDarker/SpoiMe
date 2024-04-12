package com.example.spoilme.exception;

import com.example.spoilme.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
@Component
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        log.info("其他异常{}", ex.getMessage());
        log.info("其他异常{}", ex.getCause().getMessage());
        return Result.error("操作失败");
    }
    @ExceptionHandler({ServiceException.class})
    public Result exceptionHandler(ServiceException e){
        //Result是统一封装的一个返回实体
        return Result.error(e.getMessage());
    }

}
