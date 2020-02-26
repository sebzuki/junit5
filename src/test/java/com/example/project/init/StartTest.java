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
package com.example.project.init;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

class StartTest {

    @BeforeAll
    static void initAll() {
    }

    @AfterAll
    static void tearDownAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void succeeding_test() {
    }

    @Test
    @Disabled("for demonstration purposes")
    void skipped_Test() {
        // not executed
    }

    @AfterEach
    void tearDown() {
    }
}