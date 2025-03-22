package com.sreeram.blog.Blog.Controller;

import com.sreeram.blog.Blog.Model.PostModel;
import com.sreeram.blog.Blog.Repository.PostRepository;
import com.sreeram.blog.Blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;

    @PostMapping("/addPost")
    public void addPost(@RequestBody PostModel postModel){
        if(postService.isEmailForPostAlreadyExist(postModel))
        {
            postService.savePost(postModel);
        };
    }

}
