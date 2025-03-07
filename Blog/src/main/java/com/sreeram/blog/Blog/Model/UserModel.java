package com.sreeram.blog.Blog.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long id;

    public String name;
}
