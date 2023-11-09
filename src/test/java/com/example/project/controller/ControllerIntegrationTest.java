package com.example.project.controller;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    //@MethodSource("thisTestArgs")
    @ParameterizedTest
    @CsvFileSource(resources = "/integration/test-integration.csv", numLinesToSkip = 1)
    void find_must_call_and_return_response(String name, String json) throws Exception {
        mockMvc.perform(get("/api/saveAndFind/" + name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(readFileAsString("/integration/" + json)));
    }

    // solution alternative au fichier CSV
    static Stream<Arguments> thisTestArgs() {
        return Stream.of(
                arguments("Sweden", "saveAndFind1.json"),
                arguments("Poland", "saveAndFind2.json"),
                arguments("France", "saveAndFind3.json")
        );
    }

    String readFileAsString(String file) throws Exception {
        return new String(Files.readAllBytes(new ClassPathResource(file).getFile().toPath()));
    }
}
