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
package com.example.project.file;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    @TempDir
    static Path sharedTempDir;

    @Test
    void writeItemsToFile() throws IOException {
        Path file = Files.createFile(sharedTempDir.resolve("test.txt"));
        Files.write(file, List.of("a", "b", "c"));
        assertThat(Files.readAllLines(file)).containsExactlyInAnyOrder("a", "b", "c");
    }

    @Test
    void writeItemsToFile(@TempDir Path tempDir) throws IOException {
        Path file = Files.createFile(tempDir.resolve("test2.txt"));
        Files.write(file, List.of("a", "b", "c"));
        assertThat(Files.readAllLines(file)).containsExactlyInAnyOrder("a", "b", "c");
    }
}
