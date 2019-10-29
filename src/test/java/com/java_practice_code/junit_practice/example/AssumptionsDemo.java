package com.java_practice_code.junit_practice.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsDemo {
    private final Calculator calculator = new Calculator();

    @Test
    void testOnlOnCisServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
        // remainder of test
    }
}
