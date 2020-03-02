package com.example.project.dao;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.Set;

@Entity
public class BookmarkEntity {

    @Id
    private String url;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> tags;

    public BookmarkEntity() {
    }

    public BookmarkEntity(String url, String name, Set<String> tags) {
        this.url = url;
        this.name = name;
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
