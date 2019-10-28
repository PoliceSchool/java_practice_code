package com.java_practice_code.junit_practice.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
}
