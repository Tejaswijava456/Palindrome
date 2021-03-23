package com.springBoot.palindrome.controller;

import com.springBoot.palindrome.service.PalindromeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@AllArgsConstructor
public class PalindromeController { // Rest controller, handles all the rest endpoints

    private PalindromeService palindromeService;

    // Get endpoint for getting the longest palindrome from the provided input
    @GetMapping(value = "/palindrome/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProducts(@PathVariable("inputString") String inputString)
    {
        try {
            return new ResponseEntity(Collections.singletonMap("Result", palindromeService.getLongestPalindrome(inputString)), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve the longest palindrome from the provided input");
        }
    }
}
