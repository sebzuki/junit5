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

class StartTest {

    @BeforeAll
    static void initAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("AfterAll");
    }

    @BeforeEach
    void init() {
        System.out.println("BeforeEach");
    }

    @Test
    void succeeding_test() {
        System.out.println("Test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skipped_Test() {
        // not executed
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }
}