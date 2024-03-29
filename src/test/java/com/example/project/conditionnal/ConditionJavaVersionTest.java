/*
 * Sebastien Leboucher
 */
package com.example.project.conditionnal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ConditionJavaVersionTest {
    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void onlyOnJava8() {
        // ...
    }

    @Test
    @EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
    void onJava9Or10() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void fromJava9to11() {
        // ...
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9)
    void fromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_11)
    void fromJava8To11() {
        // ...
    }

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void notOnJava9() {
        // ...
    }

    @Test
    @DisabledOnJre(JRE.JAVA_11)
    void notOnJava11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void notFromJava9to11() {
        // ...
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9)
    void notFromJava9toCurrentJavaFeatureNumber() {
        // ...
    }

    @Test
    @DisabledForJreRange(max = JRE.JAVA_11)
    void notFromJava8to11() {
        // ...
    }
}
