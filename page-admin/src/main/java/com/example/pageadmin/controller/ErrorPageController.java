package com.example.pageadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

   @RequestMapping("/hello")
    public String hello(){
       //throw new RuntimeException("xxx");
       return "hello";
   }

   @RequestMapping("/errorPage")
   public String errorPage(){
       System.out.println("异常处理界面");
        return "errorPage";
   }

}
