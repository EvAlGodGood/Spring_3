package com.geekbrains.webapp.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class studentController {
    @GetMapping("/info")
    @ResponseBody
    public String demoInfo (){
        return "Привет, Мир!!!";
    }

    @GetMapping("/echo")
    @ResponseBody
    public String echoRequest (@RequestParam(name = "word", defaultValue = " .. ") String word){
        return "Echo: " + word;
    }

}
