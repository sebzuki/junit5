/*
 * Sébastien Leboucher
 */
package com.example.project.service;

import com.example.project.dao.HelloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    private final HelloRepository helloRepository;

    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
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
}
