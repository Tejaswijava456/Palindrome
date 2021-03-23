package com.springBoot.palindrome.config;

import com.springBoot.palindrome.controller.PalindromeController;
import com.springBoot.palindrome.repository.PalindromeRepository;
import com.springBoot.palindrome.service.PalindromeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ServiceConfig { // Config class responsible for creating all the required beans

    // Bean for repository class
    @Autowired
    PalindromeRepository palindromeRepository;

    // Bean for service class
    @Bean
    public PalindromeService palindromeService(){
        return new PalindromeService(palindromeRepository);
    }

    // Bean for controller class
    @Bean
    public PalindromeController palindromeController() {
        return new PalindromeController(palindromeService());
    }
}
