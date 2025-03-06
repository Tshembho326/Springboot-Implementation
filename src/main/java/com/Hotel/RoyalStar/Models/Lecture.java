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

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    public Lecture() {}

    public Lecture(String name, Section section) {
        this.name = name;
        this.section = section;
    }

    public Lecture(int id, String name, Section section) {
        this.id = id;
        this.name = name;
        this.section = section;
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
