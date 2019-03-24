package com.example.pageadmin.config;


import com.alibaba.fastjson.JSONObject;
import com.example.pageadmin.common.response.ApiResponse;
import com.example.pageadmin.model.ValidateError;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class WebExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String url = request.getRequestURL().toString();

        Map<String, Object> error = getModelAndViewError(e);
        //json数据请求
        if (url.endsWith(".json")){
            return new ModelAndView("jsonView",error);
        }
        //处理其他异常

        getModelAndViewError(e);
        ModelAndView mv = new ModelAndView("/errorPage");
        mv.addObject("errorMessage",error);
        return mv;
    }

    /**
     * 处理json响应异常
     * @param e
     * @return
     */
    private Map<String,Object> getModelAndViewError(Exception e) {
        //参数校验异常
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ValidateError> result = getValidateErrors(ex);
            //异常内容
            ApiResponse apiResponse = ApiResponse.ofMessage(ApiResponse.Status.INVALID_PARAM.getCode(), ApiResponse.Status.INVALID_PARAM.getMessage(), result);
            return apiResponse.toMap();
        }
        if (e instanceof MaxUploadSizeExceededException){
           return ApiResponse.ofStatus(ApiResponse.Status.UPLOAD_SIZE_TOO_BIG).toMap();
        }

        //2.其他类型异常
        return ApiResponse.ofStatus(ApiResponse.Status.INTERNAL_SERVER_ERROR).toMap();
    }

    /**
     * 获取异常下信息
     * @param ex
     * @return
     */
    private List<ValidateError> getValidateErrors(BindException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        List<ValidateError> result = new ArrayList<>();

        fieldErrors.forEach(fieldError -> result.add(
                ValidateError.build(fieldError.getField(), fieldError.getDefaultMessage())
        ));
        return result;
    }
}
