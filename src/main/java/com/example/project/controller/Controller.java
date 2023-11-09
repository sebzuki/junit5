/*
 * Sebastien Leboucher
 */
package com.example.project.controller;

import com.example.project.service.BookmarkDTO;
import com.example.project.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    private final HelloService helloService;

    public Controller(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String find() {
        return helloService.find();
    }

    @GetMapping(value = "/saveAndFind/{arg}")
    public BookmarkDTO saveAndFind(@PathVariable String arg) {
        return helloService.saveAndFind(arg);
    }
}
