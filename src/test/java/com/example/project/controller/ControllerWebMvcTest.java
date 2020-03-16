package com.example.project.controller;

import com.example.project.service.HelloService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(
        controllers = Controller.class
)
class ControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HelloService helloService;

    @Test
    void find_must_call_and_return_response() throws Exception {
        when(helloService.find()).thenReturn("yes!");

        mockMvc.perform(get("/api"))
                .andExpect(content().string(helloService.find()))
                .andExpect(status().isOk());
    }
}