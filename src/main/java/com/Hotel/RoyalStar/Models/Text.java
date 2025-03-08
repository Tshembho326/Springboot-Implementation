package com.Hotel.RoyalStar.Models;


import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class Text extends Resource {

    private String content;

    public Text() {}

    public Text(ResourceBuilder<?, ?> b, String content) {
        super(b);
        this.content = content;
    }

    public Text(String content) {
        this.content = content;
    }

    public Text(String name, int size, String url, Lecture lecture, String content) {
        super(name, size, url, lecture);
        this.content = content;
    }

    public Text(int id, String name, int size, String url, Lecture lecture, String content) {
        super(id, name, size, url, lecture);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
