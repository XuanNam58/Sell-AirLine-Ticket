package com.example.sell_airline_ticket.controller.user;

import com.example.sell_airline_ticket.entity.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/contact.html")
    public String contact(){
        return "user/contact";
    }

    @GetMapping("/gallery.html")
    public String gallery(){
        return "user/gallery";
    }

    @GetMapping("/blog.html")
    public String blog(){
        return "user/blog";
    }


    @Autowired
    private PlaneService planeService;
    @GetMapping("/plane.html")
    public String getUsers(Model model) {
        try {
            List<Plane> users = planeService.getUsers();
            model.addAttribute("users", users);
        } catch (RuntimeException e) {
            model.addAttribute("error", "User not found");
            return "user/contact";  // Chuyển hướng đến trang lỗi tùy chỉnh nếu có
        }
//        Plane users = planeService.getUser();
//        model.addAttribute("users", users);
        return "user/blog";
    }

//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/users.html")
//    public String getUsers(Model model) {
//        List<User> users = userService.getUsers();
//        model.addAttribute("users", users);
//        return "user/blog";
//
////        try {
////            List<User> user1 = userService.getUsers();
////            model.addAttribute("user", user1);
////        } catch (RuntimeException e) {
////            model.addAttribute("error", "User not found");
////            return "user/blog";  // Chuyển hướng đến trang lỗi tùy chỉnh nếu có
////        }
////        return "user/test";
//    }
}
