package com.example.project.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class JpaBookmarkRepositoryTest {
    private ObjectMapper objectMapper;
    private SoftAssertions softly = new SoftAssertions();

    @Autowired private JpaBookmarkRepository repository;
    @PersistenceContext private EntityManager em;

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper().findAndRegisterModules();
    }

    @ParameterizedTest
    @MethodSource("bookmark")
    void findAll_should_list_all_bookmarks(BookmarkEntity bookmark, BookmarkEntity bookmark2) {
        repository.saveAll(List.of(bookmark, bookmark2));

        assertThat(repository.findAll())
                .extracting(BookmarkEntity::getName)
                .containsExactlyInAnyOrder(bookmark.getName(), bookmark2.getName());
    }

    @ParameterizedTest
    @MethodSource("bookmark")
    void findByUrl_should_select_bookmark_by_url_name(BookmarkEntity bookmark, BookmarkEntity bookmark2) throws IOException {
        em.persist(bookmark);
        repository.save(bookmark2);

        Optional<BookmarkEntity> result = repository.findByUrl("http://www.junit.org");

        assertThat(result).isNotEmpty();
        // assert unitaires
        assertThat(result.get().getName()).isEqualTo(bookmark.getName());
        // assert de tous les champs - faiblesse : echoue si un sous objet existe (a cause de la reference)
        assertThat(result.get()).isEqualToComparingFieldByField(bookmark);
        // assert de tous les champs et recursivement de tous les champs des sous objets
        assertThat(result.get()).usingRecursiveComparison().isEqualTo(bookmark);

        // assert de tous le champs en mode visuel, utilise si une conversion d'objet est faite
        BookmarkEntity expectedBookmark =
                objectMapper.readValue(new ClassPathResource("bookmark.json").getFile(), BookmarkEntity.class);
        String actual = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(result.get());
        String expected = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedBookmark);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("bookmark")
    void findByUrl_should_select_bookmark_by_url_name_softly(BookmarkEntity bookmark, BookmarkEntity bookmark2) throws IOException {
        repository.saveAll(List.of(bookmark, bookmark2));

        Optional<BookmarkEntity> result = repository.findByUrl("http://www.junit.org");
        softly.assertThat(result).isNotEmpty();
        softly.assertThat(result.get().getName()).isEqualTo(bookmark.getName());
        softly.assertThat(result.get()).isEqualToComparingFieldByField(bookmark); // fail if nested objects
        softly.assertThat(result.get()).usingRecursiveComparison().isEqualTo(bookmark);

        BookmarkEntity expectedBookmark =
                objectMapper.readValue(new ClassPathResource("bookmark.json").getFile(), BookmarkEntity.class);
        String actual = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(result.get());
        String expected = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(expectedBookmark);
        softly.assertThat(actual).isEqualTo(expected);
        softly.assertAll();
    }

    static Stream<Arguments> bookmark() {
        return Stream.of(
                arguments(
                        new BookmarkEntity("http://www.junit.org", "JUnit", singleton("test")),
                        new BookmarkEntity("http://www.junit2.org", "JUnit2", singleton("test2"))
                ));
    }
}
