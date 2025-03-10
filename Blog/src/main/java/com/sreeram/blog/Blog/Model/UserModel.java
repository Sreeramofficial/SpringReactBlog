package com.sreeram.blog.Blog.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor // Lombok will generate a no-args constructor
@AllArgsConstructor // Lombok will generate a constructor with all fields as parameters
@ToString
@Table(name = "blog_user")
public class UserModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Posts> posts;

    // Lombok generates the constructor, getters, setters, and toString for you, so no need to manually write them.

    public UserModel getAndUpdateUser() {
        return this;
    }
}
