package com.sem4.bookstore.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "UserName", nullable = false, length = 250)
    private String userName;

    @Column(name = "Password", nullable = false, length = 250)
    private String password;

    @Nationalized
    @Column(name = "FullName", nullable = false, length = 250)
    private String fullName;

    @Column(name = "CreatedDate")
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}