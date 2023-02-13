package com.sem4.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping ("/Admin")
    public String adminManager(){
        return "Admin/AdminLayout";
    }
}
