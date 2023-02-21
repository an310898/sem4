package com.sem4.bookstore.controller.admin;

import com.sem4.bookstore.model.Category;
import com.sem4.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("edit/{cateId}")
    public String editCategoryForm(@PathVariable("cateId")int cateId,Model model){
            Category category = categoryRepository.findById(cateId).orElseThrow(()->new IllegalArgumentException("Invalid user Id: "+ cateId));
            model.addAttribute("cateId",cateId);
            model.addAttribute("category",category);
          return "admin/categories/EditCategory";
    }

    @PostMapping("update/{cateId}")
    public String updateCategory(@PathVariable("cateId")int cateId,Category category, Model model, BindingResult bindingResult){
        category.setId(cateId);
        category.setCreatedDate(Date.from(Instant.now()));
        categoryRepository.save(category);
        return "redirect:/admin/category/getall";
    }

    @GetMapping("delete/{cateId}")
    public String deleteCategory(@PathVariable("cateId")int cateId){
        categoryRepository.deleteById(cateId);
        return "redirect:/admin/category/getall";
    }
}
