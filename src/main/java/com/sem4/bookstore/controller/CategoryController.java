package com.sem4.bookstore.controller;

import com.sem4.bookstore.model.Category;
import com.sem4.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/getall")
    public String getAll(Model model){

        model.addAttribute("category",categoryRepository.findAll());
        return "admin/categories/CategoryManager";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category",new Category());
        return "admin/categories/AddCategory";
    }

    @PostMapping("/save")
    public String addCategory(Category cate){
        cate.setCreatedDate(Date.from(Instant.now()));
            categoryRepository.save(cate);
            return "redirect:/admin/category/getall";
    }
}
