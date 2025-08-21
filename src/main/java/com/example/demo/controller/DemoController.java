package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hi, i'm here.";
    }

    @GetMapping("/bye")
    public String Bye(){
        return "Bye, see you tomorrow.";
    }

}
