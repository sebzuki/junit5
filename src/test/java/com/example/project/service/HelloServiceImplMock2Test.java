package com.example.project.service;

import com.example.project.dao.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplMock2Test {
    public static final String HELLO = "Hello Seb";
    private HelloServiceImpl helloService;

    @Mock private HelloRepository helloRepository;

    @BeforeEach
    void init() {
        helloService = new HelloServiceImpl(helloRepository);
    }

    @Test
    void find_should_return_reponse_of_repository() {
        when(helloRepository.find()).thenReturn(HELLO);

        assertThat(helloService.find()).isEqualTo(HELLO);
    }

    @Test
    void other_should_return_reponse_of_find() {
        when(helloRepository.find()).thenReturn(HELLO);

        // ça n'est pas vraiment ce que l'on teste ici... rien ne permet de savoir que other a été appelé, on va voir si on peut faire mieux
        assertThat(helloService.other()).isEqualTo(HELLO);
    }
}