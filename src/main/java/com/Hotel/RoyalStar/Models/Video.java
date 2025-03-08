package com.Hotel.RoyalStar.Models;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class Video extends Resource {

    private int length;

    public Video() {}

    public Video(String name, int size, String url, Lecture lecture, int length) {
        super(name, size, url, lecture);
        this.length = length;
    }

    public Video(int id, String name, int size, String url, Lecture lecture, int length) {
        super(id, name, size, url, lecture);
        this.length = length;
    }

    public Video(ResourceBuilder<?, ?> b, int length) {
        super(b);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
