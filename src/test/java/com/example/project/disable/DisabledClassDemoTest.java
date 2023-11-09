/*
 * Sebastien Leboucher
 */
package com.example.project.disable;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemoTest {

    @Test
    void testWillBeSkipped() {
    }
}
