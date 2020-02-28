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
    @DisplayName("&é'(-è_çà)=")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    void test_with_display_name_containing_underscore() {
    }
}
