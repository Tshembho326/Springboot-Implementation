package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table
public class Lecture {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "lecture_sequence"
    )
    @SequenceGenerator(
            name = "lecture_sequence",
            sequenceName = "lecture_sequence",
            allocationSize = 1
    )
    private Integer id;

    private String name;

    public Lecture() {}

    public Lecture(String name) {
        this.name = name;
    }

    public Lecture(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
