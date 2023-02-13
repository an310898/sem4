package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}