package com.example.spoilme.exception;

import com.example.spoilme.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

//TODO : 用于捕捉异常，在@ExceptionHandler()中填上需要捕获的异常类型

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result ex(Exception ex){
        if (ex instanceof SQLException){
            log.info("SQL异常"+ex.getMessage());
            return Result.error("后台数据库发生异常");
        }
        log.info("其他异常{}", ex.getMessage());
        return Result.error("操作失败");
    }

}
