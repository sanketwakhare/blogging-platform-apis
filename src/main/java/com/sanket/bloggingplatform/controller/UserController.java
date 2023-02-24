package com.sanket.bloggingplatform.controller;

import com.sanket.bloggingplatform.dtos.CreateUserRequestDto;
import com.sanket.bloggingplatform.dtos.CreateUserResponseDto;
import com.sanket.bloggingplatform.dtos.ResponseStatus;
import com.sanket.bloggingplatform.models.User;
import com.sanket.bloggingplatform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create-user")
    public CreateUserResponseDto createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto();
        try {
            String username = createUserRequestDto.getUsername();
            String bio = createUserRequestDto.getBio();
            User user = userService.createUser(username, bio);
            createUserResponseDto.setUser(user);
            createUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            createUserResponseDto.setMessage("user created");
        } catch (Exception e) {
            createUserResponseDto.setResponseStatus(ResponseStatus.SERVER_ERROR);
            createUserResponseDto.setMessage(e.getMessage());
        }
        return createUserResponseDto;
    }
}
