package com.sreeram.blog.Blog.Controller;


import com.sreeram.blog.Blog.Model.UserModel;
import com.sreeram.blog.Blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController     {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUser")
    public  void addUser(@RequestBody UserModel userModel){
        userRepository.save(userModel);
    }

    @GetMapping("/getUser")
    public List<UserModel> getUser(){
        return userRepository.findAll();
    }


}
