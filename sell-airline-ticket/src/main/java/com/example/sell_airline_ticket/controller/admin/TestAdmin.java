package com.example.sell_airline_ticket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TestAdmin {
    @GetMapping({"/", "/index.html"})
    public String index() {
        return "admin/index";
    }
    @GetMapping("font-fontawesome.html")
    public String fontAware() {
        return "admin/font-fontawesome";
    }
    @GetMapping("font-themify.html")
    public String fontThemify() {
        return "admin/font-themify";
    }
}
