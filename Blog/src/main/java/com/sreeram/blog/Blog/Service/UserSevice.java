package com.sreeram.blog.Blog.Service;

import com.sreeram.blog.Blog.Exception.UnderEighteenNotAllowed;
import com.sreeram.blog.Blog.Exception.UserNotFoundException;
import com.sreeram.blog.Blog.Model.UserModel;
import com.sreeram.blog.Blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserSevice {
    @Autowired
    UserRepository userRepository;

    public boolean isAgeGreaterThanEighteen(UserModel userModel) {

        if (userModel.getAge() < 18) {
            throw new UnderEighteenNotAllowed("User is Under 18");
        } else if (isEmailAlreadyExist(userModel)) {
            throw new UserNotFoundException("User Already exist with same EmailID");
        } else {
            userRepository.save(userModel);
        }
        return true;
    }

    public boolean isEmailAlreadyExist(UserModel userModel) {
        if (!ObjectUtils.isEmpty(userRepository.findByEmail(userModel.getEmail()))){
            return true;
        } else {
            return false;
        }
    }


}
