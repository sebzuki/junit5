package com.example.project.assertions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AssertionsDemoTest {

    @Test
    void assert_With_Hamcrest_Matcher() {
        assertThat(1, equalTo(1));
    }
}
