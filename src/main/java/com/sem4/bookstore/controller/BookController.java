package com.sem4.bookstore.controller;

import com.sem4.bookstore.model.Book;
import com.sem4.bookstore.model.User;
import com.sem4.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/BookManager")
    public String getAllUser(Model model){
        List<Book> BookList = new ArrayList<Book>();
        bookRepository.findAll().forEach(Book->BookList.add(Book));
        model.addAttribute("users",BookList);
        return "BookManager";
    }


}
