package com.example.project.display;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
class DisplayNameDemoTest {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("&e'(-è_ca)=")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    void test_with_display_name_containing_underscore() {
    }
}
