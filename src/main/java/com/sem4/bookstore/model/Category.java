package com.sem4.bookstore.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "CreatedDate")
    private Date createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}