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
package com.example.project.dao;


import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @Override
    public String find() {
        return "Hello JUnit 5";
    }

    @Override
    public void save(String str) {
        //
    }
}