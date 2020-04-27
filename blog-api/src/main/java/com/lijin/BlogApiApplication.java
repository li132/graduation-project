package com.lijin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lijin"})
@MapperScan("com.lijin.mapper")
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BlogApiApplication.class);
		app.run(args);
	}
}
