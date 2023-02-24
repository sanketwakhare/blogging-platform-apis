package com.sanket.bloggingplatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBody {
    private ResponseStatus responseStatus;
    private String message;
}
