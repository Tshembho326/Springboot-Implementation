package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;

public class Resource {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
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

    public Resource() {}

    public Resource(String name, int size, String url) {
        this.name = name;
        this.size = size;
        this.url = url;
    }

    public Resource(int id, String name, int size, String url) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.url = url;
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
