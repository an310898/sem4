package com.sem4.bookstore.repository;

import com.sem4.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select (count(u) > 0) from User u where u.userName = ?1")
    boolean exitsByUserName(String userName);

}
