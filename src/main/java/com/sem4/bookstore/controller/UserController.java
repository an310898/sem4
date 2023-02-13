package com.sem4.bookstore.controller;


import com.sem4.bookstore.model.User;
import com.sem4.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/getall")
    public String getAllUser(Model model){

        model.addAttribute("users",userRepository.findAll());
        return "admin/users/UserManager";
    }
    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("user",new User());
        return "admin/users/addUser";
    }

    @PostMapping("/save")
    public String addCategory(User user){
        user.setCreatedDate(Date.from(Instant.now()));
        userRepository.save(user);
        return "redirect:/admin/user/getall";
    }

}
