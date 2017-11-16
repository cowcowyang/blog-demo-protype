package com.fyang.me.blogdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlogDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogDemoApplication.class, args);
	}
}
