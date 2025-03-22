package com.sreeram.blog.Blog.Model;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
@Entity
@Table(name = "User_Post")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    @Column(name = "is_public",columnDefinition = "TINYINT(1)")
    private Boolean isPublic;
    private String Caption;

    private String heading;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
