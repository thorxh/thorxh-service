package com.thorxh.xh.config;

import com.thorxh.xh.result.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<Object> defaultErrorHandler(Exception e) {
        log.error("Exception", e);
        return Result.getFailedResult("an exception occurred");
    }

}
