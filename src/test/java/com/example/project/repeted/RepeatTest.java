/*
 * Sebastien Leboucher
 */
package com.example.project.repeted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class RepeatTest {
    @RepeatedTest(10)
    void repeatedTest() {
        // ...
    }

    @DisplayName("Repeat seb")
    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void customDisplayName(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        // ...
    }
}
