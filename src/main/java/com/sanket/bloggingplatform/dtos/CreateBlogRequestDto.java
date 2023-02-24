package com.sanket.bloggingplatform.dtos;

import com.sanket.bloggingplatform.models.BlogStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateBlogRequestDto {
    private List<Long> authorIds;
    private String title;
    private String body; // link/reference
    private BlogStatus blogStatus;
}
