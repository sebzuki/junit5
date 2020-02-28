package com.example.project.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplMockTest {
    private HelloServiceImpl helloService;

    @BeforeEach
    void init(@Mock HelloRepository helloRepository) {
        helloService = new HelloServiceImpl(helloRepository);
        when(helloRepository.get()).thenReturn("Hello Seb");
    }

    @Test
    void test_get() {
        assertEquals("Hello Seb", helloService.get());
    }

}