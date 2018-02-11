package com.fyang.me.blogdemo.filter;

import com.fyang.me.blogdemo.common.enums.ResponseEnum;
import com.fyang.me.blogdemo.vo.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    final Logger LOGGER = LogManager.getLogger();

    @ExceptionHandler(Exception.class)
    public Response<String> jsonErrorHandler(Exception e){
        Response<String> resp =  new Response<>(ResponseEnum.Fail);
        resp.setData(e.getMessage());
        LOGGER.error("GlobalExceptionHandler catch exception: ",e);
        return resp;
    }
}
