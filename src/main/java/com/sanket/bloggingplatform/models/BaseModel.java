package com.sanket.bloggingplatform.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @CreatedDate
    private Long createdAt;

    @LastModifiedDate
    private Long lastModifiedAt;
}
