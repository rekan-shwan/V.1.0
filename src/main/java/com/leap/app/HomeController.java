package com.leap.app;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return  "redirect:/index.html"; // Spring will look for index.html in /static/
    }
}
