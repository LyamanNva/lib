package com.example.library.management.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @GetMapping("/")
//    public String showLoginPage() {
//        return "directory/security/login";
//    }
    public String home() {
        return "home"; // Əsas səhifə üçün
    }
}
