package com.springBoot.palindrome.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PalindromeRepository extends CrudRepository<Palindrome, String> {

    // JPA Query to retrieve the longest palindrome from the given input string
    @Query(value = "select * from palindrome_svc where input_string=:input", nativeQuery = true)
    Optional<Palindrome> findPalindromeByInputString(@Param("input") String palindrome);

}
