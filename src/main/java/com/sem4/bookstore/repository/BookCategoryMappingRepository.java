package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.BookCategoryMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryMappingRepository extends JpaRepository<BookCategoryMapping, Integer> {
}