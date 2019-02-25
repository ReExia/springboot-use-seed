package com.example.restapi.config;


import com.example.restapi.common.response.ApiResponse;
import com.example.restapi.model.ValidateError;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class WebExceptionResolver {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object resolveException(Exception e) {
        //参数校验异常
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            //捕获的所有错误对象
            BindingResult bindingResult = ex.getBindingResult();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            List<ValidateError> result = new ArrayList<>();

            fieldErrors.forEach(fieldError -> result.add(
                    ValidateError.build(fieldError.getField(), fieldError.getDefaultMessage())
            ));
            //异常内容
            return ApiResponse.ofMessage(ApiResponse.Status.INVALID_PARAM.getCode(),ApiResponse.Status.INVALID_PARAM.getMessage(), result);
        }

        if (e instanceof MaxUploadSizeExceededException){
            return ApiResponse.ofStatus(ApiResponse.Status.UPLOAD_SIZE_TOO_BIG);
        }

        //2.其他类型异常
        return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR);
    }

}
