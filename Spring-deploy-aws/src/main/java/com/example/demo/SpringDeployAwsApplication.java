package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringDeployAwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDeployAwsApplication.class, args);
	}
	@GetMapping("/")
	public String home() {
		return "Welcome to AWS Spring deploy....!!!";
	}

}
