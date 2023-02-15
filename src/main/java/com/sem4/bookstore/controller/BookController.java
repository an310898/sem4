package com.sem4.bookstore.controller;

import com.sem4.bookstore.model.Book;
import com.sem4.bookstore.repository.BookRepository;
import com.sem4.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/admin/book")
@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/getall")
    public String getAll(Model model){
        model.addAttribute("books",bookRepository.findAll());
        return "admin/books/BookManager";
    }

    @GetMapping("/add")
    public String addbookForm(Model model){
        model.addAttribute("category",categoryRepository.findAll());
        model.addAttribute("book",new Book());
        return "admin/books/AddBook";
    }

    @PostMapping("/save")
    public String addbook(Book book){

        book.setCreatedDate(Date.from(Instant.now()));
        bookRepository.save(book);
        return "redirect:/admin/book/getall";
    }

    @GetMapping("edit/{bookId}")
    public String editbookForm(@PathVariable("bookId")int bookId, Model model){
        Book book = bookRepository.findById(bookId).orElseThrow(()->new IllegalArgumentException("Invalid book Id: "+ bookId));
        model.addAttribute("bookId",bookId);
        model.addAttribute("book",book);
        return "admin/books/EditBook";
    }

    @PostMapping("update/{bookId}")
    public String updatebook(@PathVariable("bookId")int bookId,Book book, Model model, BindingResult bindingResult){
        book.setId(bookId);
        book.setCreatedDate(Date.from(Instant.now()));
        bookRepository.save(book);
        return "redirect:/admin/book/getall";
    }

    @GetMapping("delete/{bookId}")
    public String deletebook(@PathVariable("bookId")int bookId){
        bookRepository.deleteById(bookId);
        return "redirect:/admin/book/getall";
    }


}
