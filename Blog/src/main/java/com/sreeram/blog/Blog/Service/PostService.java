package com.sreeram.blog.Blog.Service;

import com.sreeram.blog.Blog.Model.PostModel;
import com.sreeram.blog.Blog.Model.UserModel;
import com.sreeram.blog.Blog.Repository.PostRepository;
import com.sreeram.blog.Blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Service
public class PostService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PostRepository postRepository;
    public boolean isEmailForPostAlreadyExist(PostModel postModel) {
        if (!ObjectUtils.isEmpty(userRepository.findByEmail(postModel.getEmail()))){
            return true;
        } else {
            return false;
        }
    }
    public void savePost(PostModel postModel){
        if(isEmailForPostAlreadyExist(postModel)){
            postRepository.save(postModel);
        }
    }
}
