package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table
public class Resource extends BaseEntity{
    private String name;
    private int size;

    @Column(unique = true)
    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public Resource() {}

    public Resource(String name, int size, String url, Lecture lecture) {
        this.name = name;
        this.size = size;
        this.url = url;
        this.lecture = lecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Resources{" +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", url='" + url + '\'' +
                '}';
    }
}
