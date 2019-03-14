package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParameterController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/appName")
    String getAppName() {
        return "Hello World! Application name is : " + appName;
    }

}
