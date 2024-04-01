package com.myproject.MyProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/api")
    public String home() {
        return "This is Home Page.";
    }
}
