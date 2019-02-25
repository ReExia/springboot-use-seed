package com.example.restapi.config.error;

import com.example.restapi.common.response.ApiResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerErrorController implements ErrorController {


    @RequestMapping(value = "/error")
    public ApiResponse dealError(Exception ex) {
        return ApiResponse.ofStatus(ApiResponse.Status.NOT_FOUND);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
