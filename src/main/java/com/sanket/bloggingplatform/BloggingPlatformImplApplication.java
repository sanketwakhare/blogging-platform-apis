package com.sanket.bloggingplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BloggingPlatformImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingPlatformImplApplication.class, args);
    }

}
