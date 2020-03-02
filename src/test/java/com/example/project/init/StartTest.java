/*
 * Sébastien Leboucher
 */
package com.example.project.init;

import org.junit.jupiter.api.*;

class StartTest {

    @BeforeAll
    static void initAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void init() {
        System.out.println("BeforeEach");
    }

    @Test
    void succeeding_test() {
        System.out.println("Test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skipped_Test() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }
}