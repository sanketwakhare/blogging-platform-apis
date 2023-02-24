package com.sanket.bloggingplatform.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="blog")
public class Blog extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Long blogId;

    private String title;

    private String body; // link/reference

    @Enumerated(EnumType.STRING)
    private BlogStatus blogStatus;

    @ManyToMany
    @JoinTable(name = "blog_authors",
            joinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private List<User> authors;
}
