package com.springBoot.palindrome.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "palindrome_svc")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Palindrome { // Model class for palindrome
    @Id
    @Column(name = "inputString", nullable = false)
    private String inputString;

    @Column(name = "palindromeString", nullable = false)
    private String palindromeString;
}

