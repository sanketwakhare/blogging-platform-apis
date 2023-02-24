package com.sanket.bloggingplatform.services;

import com.sanket.bloggingplatform.models.Blog;
import com.sanket.bloggingplatform.models.BlogStatus;
import com.sanket.bloggingplatform.models.User;
import com.sanket.bloggingplatform.repositories.BlogRepository;
import com.sanket.bloggingplatform.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    public Blog createBlog(String title, String body, List<Long> authorIds, BlogStatus blogStatus) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);
        blog.setBlogStatus(Objects.isNull(blogStatus) ? BlogStatus.DRAFT : blogStatus);

        // find authors and update in blog object
        List<User> authors = userRepository.findAllById(authorIds);
        blog.setAuthors(authors);

        // update epoch timestamp
        Long now = Instant.now().toEpochMilli();
        blog.setCreatedAt(now);
        blog.setLastModifiedAt(now);

        return blogRepository.saveAndFlush(blog);
    }
}
