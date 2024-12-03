package com.example.sell_airline_ticket.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping({"/", "/index.html"})
    public String index() {
        return "user/index";
    }

    @GetMapping("/about.html")
    public String about() {
        return "user/about";
    }

    @GetMapping("/login.html")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/register.html")
    public String registerPage() {
        return "user/register";
    }

    @GetMapping("/info.html")
    public String info(){ return "user/info";}

    @GetMapping("/gallery.html")
    public String gallery(){return "user/gallery";}

    @GetMapping("/contact.html")
    public String contact(){return "user/contact";}
}
