package com.instagram.clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@SpringBootApplication
public class CloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneApplication.class, args);
	}

}


@Configuration
class WebConfig {
	// MultipartResolver를 구성합니다.
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
}