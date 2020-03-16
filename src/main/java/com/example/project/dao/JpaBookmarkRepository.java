package com.example.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaBookmarkRepository extends CrudRepository<BookmarkEntity, String> {
    Optional<BookmarkEntity> findByUrl(String url);

    List<BookmarkEntity> findAll();
}
