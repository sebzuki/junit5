package com.example.project.service;

import com.example.project.dao.HelloRepository;
import com.example.project.dao.JpaBookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplMockTest {
    public static final String HELLO = "Hello Seb";
    private HelloServiceImpl helloService;

    @BeforeEach
    void init(@Mock HelloRepository helloRepository, @Mock JpaBookmarkRepository bookmarkRepository) {
        helloService = new HelloServiceImpl(helloRepository, bookmarkRepository);
        lenient().when(helloRepository.find()).thenReturn(HELLO);
    }

    @Test
    void find_should_return_reponse_of_repository() {
        assertThat(helloService.find()).isEqualTo(HELLO);
    }

    @Test
    void other_should_return_reponse_of_repository() {
        assertThat(helloService.other()).isEqualTo(HELLO);
    }
}
