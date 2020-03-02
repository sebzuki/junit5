/*
 * Sébastien Leboucher
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
