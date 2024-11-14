package com.example.sell_airline_ticket.controller.admin;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {
    @GetMapping({"/", "/index", ""})
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("currentUri", request.getRequestURI());
        //        model.addAttribute("httpServletRequest", request);
        return "admin/index";
    }

    @GetMapping("font-fontawesome")
    public String fontAware() {
        return "admin/font-fontawesome";
    }

    @GetMapping("font-themify")
    public String fontThemify() {
        return "admin/font-themify";
    }
}
