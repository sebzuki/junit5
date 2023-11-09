package com.example.project.service;

import com.example.project.dao.HelloRepository;
import com.example.project.dao.JpaBookmarkRepository;
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
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HelloServiceImplSpyTest {
    public static final String HELLO = "Hello Seb";
    private HelloServiceImpl helloService;

    @Mock private HelloRepository helloRepository;
    @Mock private JpaBookmarkRepository bookmarkRepository;

    @Captor private ArgumentCaptor<String> stringArgumentCaptor;

    @BeforeEach
    void init() {
        helloService = spy(new HelloServiceImpl(helloRepository, bookmarkRepository));
    }

    @Test
    void find_should_return_reponse_of_repository() {
        when(helloRepository.find()).thenReturn(HELLO);

        assertThat(helloService.find()).isEqualTo(HELLO);
    }

    @Test
    void other_should_return_reponse_of_find() {
        doReturn(HELLO).when(helloService).find();

        assertThat(helloService.other()).isEqualTo(HELLO);

        verify(helloService, times(1)).find();
    }

    // pour un type void, verify est indispensable
    @Test
    void process_should_call_save_repository() {
        helloService.process(List.of("toto", "seb"));

        verify(helloRepository, times(1)).save(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue()).isEqualTo("seb");
    }

    @ParameterizedTest
    @MethodSource("listArg")
    void process_should_call_save_repository_with_selected_values(String str, List<String> list) {
        helloService.process(list);

        verify(helloRepository, times(1)).save(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue()).isEqualTo(str);
    }

    // pas necessaire pour la couverture mais pour le use case qu'il represente
    @Test
    void process_should_not_call_save_repository() {
        helloService.process(List.of("patates", "croutons"));

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
