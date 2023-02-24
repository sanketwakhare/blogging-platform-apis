package com.sanket.bloggingplatform.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequestDto {
    private String username;
    private String bio;
}
