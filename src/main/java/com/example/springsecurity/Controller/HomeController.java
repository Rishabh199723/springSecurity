package com.example.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String dashboard() {
        return "Home dashboard";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin dashboard";
    }
}
