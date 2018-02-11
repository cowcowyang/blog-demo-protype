package com.fyang.me.blogdemo.filter;

import com.fyang.me.blogdemo.common.enums.ResponseEnum;
import com.fyang.me.blogdemo.vo.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
  * @auther:fyang
  * @date: 2018/2/11
  * @description: 全局异常统一处理
  *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    final Logger LOGGER = LogManager.getLogger();


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> jsonErrorHandler(Exception e){
        Response<String> resp =  new Response<>(ResponseEnum.Fail);
        resp.setData(e.getMessage());
        LOGGER.error("GlobalExceptionHandler.jsonErrorHandler catch exception: ",e);
        return ResponseEntity.ok(resp);
    }

    /**
      * @auther:fyang
      * @date: 2018/2/11
      * @description: JSR-303校验异常
      *
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response<String>> entityViolationHandler(ConstraintViolationException e){
        Response<String> resp =  new Response<>(ResponseEnum.Fail);
        resp.setData(e.getMessage());
        LOGGER.error("GlobalExceptionHandler.entityViolationHandler catch exception: {}",e.getMessage());
        return ResponseEntity.ok(resp);
    }
}
