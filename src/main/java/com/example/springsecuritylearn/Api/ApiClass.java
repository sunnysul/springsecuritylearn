package com.example.springsecuritylearn.Api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiClass {

    @GetMapping("/login")
    public String getMethodName() {
        return "Login API called";
    }

    @GetMapping("/register")
    public String getMethodName2() {
        return "Register API called";
    }

    @GetMapping("/authonly")
    public String getMethodName3() {
        return "Auth only API called";
    }

}
