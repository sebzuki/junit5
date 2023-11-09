/*
 * Sebastien Leboucher
 */
package com.example.project.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ParamExterneTest {
        @ParameterizedTest
        @MethodSource("com.example.project.parametrized.StringsProviders#tinyStrings")
        void testWithExternalMethodSource(String tinyString) {
            // test with tiny string
        }
}

class StringsProviders {
    static Stream<String> tinyStrings() {
        return Stream.of(".", "oo", "OOO");
    }
}
