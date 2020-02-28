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
package com.example.project.repeted;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class RepeatTest {
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
