package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Procedure("BookCategoryMap")
    void BookCategoryMapping(int BookId,String CategoryIdArrays);
}