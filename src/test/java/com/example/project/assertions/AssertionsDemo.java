package com.example.project.assertions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertionsDemo {

    @Test
    void assert_With_Hamcrest_Matcher() {
        assertThat(4 - 1).isEqualTo(3);
    }
}
