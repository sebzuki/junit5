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
package com.example.project.conditionnal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class ConditionOsTest {

    @Test
    @EnabledOnOs(OS.MAC)
    void onlyOnMacOs() {
        // ...
    }

    @TestOnWin
    void testOnWin() {
        // ...
    }

    @Test
    @EnabledOnOs({ OS.LINUX, OS.WINDOWS })
    void onLinuxOrWindows() {
        // ...
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void notOnWindows() {
        // ...
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(OS.WINDOWS)
    @interface TestOnWin {
    }
}
