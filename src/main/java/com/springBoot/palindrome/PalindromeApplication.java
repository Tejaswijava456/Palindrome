package com.springBoot.palindrome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.SpringBoot.palindrome.config") // For running the config class, so that it creates beans before even starting the spring-boot server.
public class PalindromeApplication extends SpringBootServletInitializer { // Spring-boot application class with main method

	public static void main(String[] args) {
		SpringApplication.run(PalindromeApplication.class, args);
	}

}
