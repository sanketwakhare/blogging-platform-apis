package com.sanket.bloggingplatform.dtos;

import com.sanket.bloggingplatform.models.Blog;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBlogResponseDto extends ResponseBody {
    private Blog blog;
}
