package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Inheritance
@Entity
@Table
public class Resource {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "resource_generator"
    )
    @SequenceGenerator(
            name = "resource_generator",
            sequenceName = "resource_generator",
            allocationSize = 1
    )
    private Integer id;
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

    public Resource(int id, String name, int size, String url, Lecture lecture) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.url = url;
        this.lecture = lecture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", url='" + url + '\'' +
                '}';
    }
}
