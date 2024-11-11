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

    @GetMapping("/accomodation.html")
    public String accomodation() {
        return "user/accomodation";
    }
}
