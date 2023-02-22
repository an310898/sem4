package com.sem4.bookstore.controller.site;

import com.sem4.bookstore.model.Book;
import com.sem4.bookstore.model.Category;
import com.sem4.bookstore.repository.BookRepository;
import com.sem4.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookStoreController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "site/index";
    }
}
