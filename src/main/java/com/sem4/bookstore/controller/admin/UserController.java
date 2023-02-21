package com.sem4.bookstore.controller.admin;


import com.sem4.bookstore.model.User;
import com.sem4.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.Date;
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
    public String addUser(User user, BindingResult result){
        if(userRepository.exitsByUserName(user.getUserName())){
            result.addError(new ObjectError("invalidUser","User name exitst, please choose another username!"));
            return "admin/users/addUser";
        }

        user.setCreatedDate(Date.from(Instant.now()));
        userRepository.save(user);
        return "redirect:/admin/user/getall";
    }

    @GetMapping("edit/{userId}")
    public String editUserForm(@PathVariable("userId")int userId, Model model){
        User user = userRepository.findById(userId).orElseThrow(()->new IllegalArgumentException("Invalid user Id: "+ userId));
        model.addAttribute("userId",userId);
        model.addAttribute("user",user);
        return "admin/users/EditUser";
    }

    @PostMapping("update/{userId}")
    public String updateUser(@PathVariable("userId")int userId,User user, Model model, BindingResult bindingResult){
        user.setId(userId);
        user.setCreatedDate(Date.from(Instant.now()));
        userRepository.save(user);
        return "redirect:/admin/user/getall";
    }

    @GetMapping("delete/{userId}")
    public String deleteUser(@PathVariable("userId")int userId){
        userRepository.deleteById(userId);
        return "redirect:/admin/user/getall";
    }

}
