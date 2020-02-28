package com.example.project.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplMock2Test {
    private HelloServiceImpl helloService;

    @Mock private HelloRepository helloRepository;

    @BeforeEach
    void init() {
        helloService = new HelloServiceImpl(helloRepository);
    }

    @Test
    void test_get() {
        when(helloRepository.get()).thenReturn("Hello Seb");
        assertEquals("Hello Seb", helloService.get());
    }

    @Test
    void other() {
        when(helloRepository.get()).thenReturn("Hello Seb");
        assertEquals("Hello Seb", helloService.other());
    }
}