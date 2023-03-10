package com.sanket.bloggingplatform.services;

import com.sanket.bloggingplatform.common.EventType;
import com.sanket.bloggingplatform.models.Blog;
import com.sanket.bloggingplatform.models.BlogStatus;
import com.sanket.bloggingplatform.models.User;
import com.sanket.bloggingplatform.repositories.BlogRepository;
import com.sanket.bloggingplatform.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    private final KafkaProducerService kafkaProducerService;

    private final TimeService timeService;

    public BlogService(BlogRepository blogRepository, UserRepository userRepository, KafkaProducerService kafkaProducerService, TimeService timeService) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
        this.kafkaProducerService = kafkaProducerService;
        this.timeService = timeService;
    }

    public Blog createBlog(String title, String body, List<Long> authorIds, BlogStatus blogStatus) {
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setBody(body);
        blog.setBlogStatus(Objects.isNull(blogStatus) ? BlogStatus.PRIVATE : blogStatus);

        // find authors and update in blog object
        List<User> authors = userRepository.findAllById(authorIds);
        blog.setAuthors(authors);

        // update epoch timestamp
        Long now = timeService.getEpochTime();
        blog.setCreatedAt(now);
        blog.setLastModifiedAt(now);

        Blog dbBlog = blogRepository.saveAndFlush(blog);

        // send message to Kafka
        Map<String, Object> data = new HashMap<>();
        data.put("blogId", dbBlog.getBlogId());
        kafkaProducerService.sendMessage(EventType.BLOG_CREATED, data);

        return dbBlog;
    }
    
    public void publishBlog(Long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(blog.isPresent()) {
            Blog dbBlog = blog.get();
            dbBlog.setBlogStatus(BlogStatus.PUBLISHED);
            Long now = timeService.getEpochTime();
            dbBlog.setLastModifiedAt(now);
            blogRepository.saveAndFlush(dbBlog);

            // send message to Kafka
            Map<String, Object> data = new HashMap<>();
            data.put("blogId", dbBlog.getBlogId());
            kafkaProducerService.sendMessage(EventType.BLOG_PUBLISHED, data);
        }
    }

    public void deleteBlog(Long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if(blog.isPresent()) {
            Blog dbBlog = blog.get();
            dbBlog.setBlogStatus(BlogStatus.DELETED);
            Long now = timeService.getEpochTime();
            dbBlog.setLastModifiedAt(now);
            blogRepository.saveAndFlush(dbBlog);

            // send message to Kafka
            Map<String, Object> data = new HashMap<>();
            data.put("blogId", dbBlog.getBlogId());
            kafkaProducerService.sendMessage(EventType.BLOG_DELETED, data);
        }
    }
}
