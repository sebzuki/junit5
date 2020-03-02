package com.example.project.service;

import com.example.project.dao.HelloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplSpyTest {
    private HelloServiceImpl helloService;

    @Mock private HelloRepository helloRepository;
    @Captor private ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeEach
    void init() {
        helloService = spy(new HelloServiceImpl(helloRepository));
    }

    @Test
    void test_get() {
        when(helloRepository.find()).thenReturn("Hello Seb");
        assertEquals("Hello Seb", helloService.find());
    }

    @Test
    void test_other() {
        doReturn("Hello get").when(helloService).find();

        assertEquals("Hello get", helloService.other());

        verify(helloService, times(1)).find();
    }

    @Test
    void captor_light() {
        helloService.captor(List.of("toto", "seb"));

        verify(helloRepository, times(1)).save(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue()).isEqualTo("seb");
    }

    @ParameterizedTest
    @MethodSource("listArg")
    void captor_parametrized_repo_called(String str, List<String> list) {
        helloService.captor(list);

        verify(helloRepository, times(1)).save(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue()).isEqualTo(str);
    }

    @Test
    void captor_parametrized_repo_never_called() {
        helloService.captor(List.of("patates", "croutons"));

        verify(helloRepository, times(0)).save(any());
    }

    static Stream<Arguments> listArg() {
        return Stream.of(
                arguments("seb", List.of("toto", "seb")),
                arguments("soupe", List.of("patates", "soupe")),
                arguments("saucisson", List.of("saucisson", "soupe"))
        );
    }
}