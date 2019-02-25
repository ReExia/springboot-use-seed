package com.example.restapi.controller;

import com.example.restapi.common.response.ApiResponse;
import com.example.restapi.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/common")
@Api(value = "FileUploadController",description = "文件上传")
public class FileUploadController {

    @Autowired
    FileService fileService;

    //@CrossOrigin(value = "http://localhost:4200") 该注解可配置局部跨域
    @PostMapping("/fileUpload")
    @ApiOperation(value = "文件上传")
    public ApiResponse fileUpload(@RequestParam("multipartFiles")MultipartFile[] multipartFiles) throws IOException {
        List<String> strings = fileService.uploadFiles(multipartFiles);
        return ApiResponse.ofSuccess(strings);
    }

}
