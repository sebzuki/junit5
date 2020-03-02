package com.example.project.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.Optional;

import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
class JpaBookmarkRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JpaBookmarkRepository repository;

    @Test
    void find_By_Url() {
        BookmarkEntity bookmark = new BookmarkEntity("http://www.junit.org", "JUnit", singleton("test"));
        //entityManager.persist(bookmark);
        repository.save(bookmark);

        Optional<BookmarkEntity> result = repository.findByUrl("http://www.junit.org");
        assertThat(result).get().isEqualToComparingFieldByField(bookmark);
    }
}