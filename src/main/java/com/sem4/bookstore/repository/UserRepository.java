package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
