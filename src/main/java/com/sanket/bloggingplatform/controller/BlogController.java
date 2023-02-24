package com.sanket.bloggingplatform.controller;

import com.sanket.bloggingplatform.dtos.CreateBlogRequestDto;
import com.sanket.bloggingplatform.dtos.CreateBlogResponseDto;
import com.sanket.bloggingplatform.dtos.ResponseStatus;
import com.sanket.bloggingplatform.models.Blog;
import com.sanket.bloggingplatform.models.BlogStatus;
import com.sanket.bloggingplatform.models.User;
import com.sanket.bloggingplatform.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final BlogService blogService;

    @Autowired
    BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("create-blog")
    public CreateBlogResponseDto createBlog(@RequestBody CreateBlogRequestDto createBlogRequestDto) {
        CreateBlogResponseDto createBlogResponseDto = new CreateBlogResponseDto();
        try {
            String title = createBlogRequestDto.getTitle();
            String body = createBlogRequestDto.getBody();
            List<Long> authorIds = createBlogRequestDto.getAuthorIds();
            BlogStatus blogStatus = createBlogRequestDto.getBlogStatus();
            Blog blog = blogService.createBlog(title, body, authorIds, blogStatus);
            createBlogResponseDto.setBlog(blog);
            createBlogResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            createBlogResponseDto.setMessage("blog created");
        } catch(Exception e) {
            createBlogResponseDto.setResponseStatus(ResponseStatus.SERVER_ERROR);
            createBlogResponseDto.setMessage(e.getMessage());
        }
        return createBlogResponseDto;
    }
}
