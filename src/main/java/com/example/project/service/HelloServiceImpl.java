/*
 * Copyright (c) 2001-2017 Group JCDecaux.
 * 17 rue Soyer, 92523 Neuilly Cedex, France.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Group JCDecaux ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you
 * entered into with Group JCDecaux.
 */
package com.example.project.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    private final HelloRepository helloRepository;

    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String get() {
        return helloRepository.get();
    }

    @Override
    public String other() {
        return get();
    }

    @Override
    public void captor(List<String> list) {
        list.stream()
                .filter(s -> s.startsWith("s"))
                .findFirst()
                .ifPresent(helloRepository::save);
    }
}
