package com.sreeram.blog.Blog.Repository;

import com.sreeram.blog.Blog.Model.PostModel;
import com.sreeram.blog.Blog.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository  extends JpaRepository<PostModel,Long>, CrudRepository<PostModel,Long> {

    List<PostModel> findByEmail(String  email);
}
