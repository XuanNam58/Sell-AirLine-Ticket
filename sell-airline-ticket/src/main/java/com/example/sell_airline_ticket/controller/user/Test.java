package com.example.sell_airline_ticket.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {
    @GetMapping("/")
    public String index() {
        return "user/index";
    }
}
