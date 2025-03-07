package com.sreeram.blog.Blog.Repository;

import com.sreeram.blog.Blog.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserModel,Long>, CrudRepository<UserModel,Long> {
}
