package com.example.project.controller;

import com.example.project.service.HelloService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ControllerStandAloneTest {
    private static final String HELLO = "hello";
    private MockMvc mockMvc;

    @Mock HelloService helloService;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(new Controller(helloService))
                //.setControllerAdvice()
                .build();
    }

    @Test
    void find_must_call_and_return_response() throws Exception {
        when(helloService.find()).thenReturn(HELLO);

        mockMvc.perform(get("/api"))
                .andExpect(content().string(HELLO))
                .andExpect(status().isOk());
    }
}