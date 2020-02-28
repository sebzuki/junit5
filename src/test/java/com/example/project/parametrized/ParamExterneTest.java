/*
 * Copyright (c) 2001-2017 Group JCDecaux.
 * 17 rue Soyer, 92523 Neuilly Cedex, France.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Group JCDecaux ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you
 * entered into with Group JCDecaux.
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