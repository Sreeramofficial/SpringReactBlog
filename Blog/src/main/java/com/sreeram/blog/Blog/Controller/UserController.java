package com.sreeram.blog.Blog.Controller;


import com.sreeram.blog.Blog.Exception.UserNotFoundException;
import com.sreeram.blog.Blog.Model.Posts;
import com.sreeram.blog.Blog.Model.UserModel;
import com.sreeram.blog.Blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("/addUser")
    public void addUser(@RequestBody UserModel userModel) {
        if (!ObjectUtils.isEmpty(userRepository.findByEmail(userModel.getEmail()))) {
            throw new UserNotFoundException("user exist");
        } else {
            List<Posts> posts =
                    userModel.getPosts();
            posts.forEach(p -> p.setUser(userModel));
          userRepository.save(userModel);
        } ;

    }

    @GetMapping("/getUser")
    public List<UserModel> getUser() {
        return userRepository.findAll();
    }

    @GetMapping("/getUserBYId/{id}")
    public UserModel getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new
                UserNotFoundException("not found"));

    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@RequestBody UserModel userModel, @PathVariable Long id) {
        UserModel user =
                userRepository.findById(id).orElseThrow(() -> new
                        UserNotFoundException("not found"));
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserModel user =
                userRepository.findById(id).orElseThrow(() -> new
                        UserNotFoundException("not found"));

        userRepository.deleteById(user.getId());
    }


}
