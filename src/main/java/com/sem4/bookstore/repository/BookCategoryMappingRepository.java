package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.BookCateMap;
import com.sem4.bookstore.model.BookCategoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface BookCategoryMappingRepository extends JpaRepository<BookCategoryMapping, Integer> {
    @Procedure("BookCategoryMap")
    void BookCategoryMapping(int BookId,String CategoryIdArrays);
}