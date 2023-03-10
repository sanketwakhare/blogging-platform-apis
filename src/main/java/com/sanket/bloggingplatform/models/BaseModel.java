package com.sanket.bloggingplatform.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @CreatedDate
    private Long createdAt;

    @LastModifiedDate
    private Long lastModifiedAt;
}
