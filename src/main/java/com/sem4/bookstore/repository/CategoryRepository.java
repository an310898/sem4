package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}