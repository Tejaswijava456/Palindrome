package com.springBoot.palindrome.service;

import com.springBoot.palindrome.repository.Palindrome;
import com.springBoot.palindrome.repository.PalindromeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class PalindromeService { // Service class, responsible for performing all the business logic
    PalindromeRepository palindromeRepository;

    // This method does 3 functionalities.
    // 1. Calculate the longest palindromic string from the input string
    // 2. Save the input string, longest palindrome in the DB
    // 3. Reads the longest palindrome from db for the provided input string
    public Palindrome getLongestPalindrome(String inputString) {
        String palindromeString = longestPalindrome(inputString);
        try {
            savePalindrome(inputString, palindromeString);
        } catch (Exception e) {
            log.error("Exception while saving data to DB");
            throw new RuntimeException("Exception while saving data to DB", e);
        }
        try {
            return palindromeRepository.findPalindromeByInputString(inputString).get();
        } catch (Exception e) {
            log.error("Exception while reading data from DB");
            throw new RuntimeException("Exception while reading data from DB", e);
        }
    }

    // Saving the input string, longest palindrome to DB
    private void savePalindrome(String inputString, String palindromeString) {
        Palindrome palindrome = Palindrome.builder().palindromeString(palindromeString).inputString(inputString).build();
        palindromeRepository.save(palindrome);
    }

    // Calculates the longest palindrome from the input string
    private String longestPalindrome(String s) {
        if(s.isEmpty()) {
            return "";
        }
        int n = s.length();
        int longestSoFar = 0, startIndex = 0, endIndex = 0;
        boolean[][] palindrome = new boolean[n][n];

        for(int j = 0; j < n; j++) {
            palindrome[j][j] = true;
            for(int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || palindrome[i+1][j-1])) {
                    palindrome[i][j] = true;
                    if(j-i+1 > longestSoFar) {
                        longestSoFar = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }
        return s.substring(startIndex, endIndex+1);
    }
}
