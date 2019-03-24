package com.example.pageadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping("/helloPage")
    public String helloPage(Model model){

        model.addAttribute("msg","Here is hello page");

        return "hello";
    }

}
