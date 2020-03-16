/*
 * S�bastien Leboucher
 */
package com.example.project.timeout;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class TimeoutDemoTest {
    @BeforeEach
    @Timeout(5)
    void setUp() {
        // fails if execution time exceeds 5 seconds
    }

    @Disabled
    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void failsIfExecutionTimeExceeds100Milliseconds() throws InterruptedException {
        Thread.sleep(120);
        // fails if execution time exceeds 100 milliseconds
    }
}
