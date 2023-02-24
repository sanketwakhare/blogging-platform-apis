package com.sanket.bloggingplatform.dtos;

import com.sanket.bloggingplatform.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponseDto extends ResponseBody {
    private User user;
}
