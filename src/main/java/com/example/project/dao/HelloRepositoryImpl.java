/*
 * Sebastien Leboucher
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
