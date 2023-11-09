package com.example.project.service;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;


@Getter
@Setter
@Accessors(chain = true)
public class BookmarkDTO {

    private String url;
    private String name;
    private Set<String> tags;
}
