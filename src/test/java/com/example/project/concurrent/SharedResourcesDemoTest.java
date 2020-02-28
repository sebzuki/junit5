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
package com.example.project.concurrent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.*;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Execution(ExecutionMode.CONCURRENT)
public class SharedResourcesDemoTest {

    private Properties backup;

    @BeforeEach
    void backup() {
        backup = new Properties();
        backup.putAll(System.getProperties());
    }

    @AfterEach
    void restore() {
        System.setProperties(backup);
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    void customPropertyIsNotSetByDefault() {
        assertNull(System.getProperty("my.prop"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    void canSetCustomPropertyToApple() {
        System.setProperty("my.prop", "apple");
        assertEquals("apple", System.getProperty("my.prop"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    void canSetCustomPropertyToBanana() {
        System.setProperty("my.prop", "banana");
        assertEquals("banana", System.getProperty("my.prop"));
    }
}
