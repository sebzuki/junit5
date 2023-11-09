/*
 * Sebastien Leboucher
 */
package com.example.project.service;

import com.example.project.dao.BookmarkEntity;
import com.example.project.dao.HelloRepository;
import com.example.project.dao.JpaBookmarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HelloServiceImpl implements HelloService {
    private final HelloRepository helloRepository;
    private final JpaBookmarkRepository bookmarkRepository;


    public HelloServiceImpl(HelloRepository helloRepository, JpaBookmarkRepository bookmarkRepository) {
        this.helloRepository = helloRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public String find() {
        return helloRepository.find();

    }

    @Override
    public String other() {
        return find();
    }

    @Override
    public void process(List<String> list) {
        list.stream()
                .filter(s -> s.startsWith("s"))
                .findFirst()
                .ifPresent(helloRepository::save);
    }

    @Override
    public BookmarkDTO saveAndFind(String arg) {
        bookmarkRepository.save(new BookmarkEntity()
                .setName(arg)
                .setUrl("BookmarkEntity "+arg)
                .setTags(Set.of("test")));
        BookmarkEntity entity = bookmarkRepository.findByName(arg).orElseThrow();
        return new BookmarkDTO()
                .setName(entity.getName())
                .setUrl(entity.getUrl())
                .setTags(entity.getTags());
    }
}
