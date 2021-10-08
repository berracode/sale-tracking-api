package com.inerxia.saletrackingapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping({"/","","/hello"})
    public String home(){
        return "Hello world";
    }
}
