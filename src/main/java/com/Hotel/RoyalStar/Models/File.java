package com.Hotel.RoyalStar.Models;


import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
public class File extends Resource {

    private String type;

    public File() {}

    public File(ResourceBuilder<?, ?> b, String type) {
        super(b);
        this.type = type;
    }

    public File(String type) {
        this.type = type;
    }

    public File(String name, int size, String url, Lecture lecture, String type) {
        super(name, size, url, lecture);
        this.type = type;
    }

    public File(int id, String name, int size, String url, Lecture lecture, String type) {
        super(id, name, size, url, lecture);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
