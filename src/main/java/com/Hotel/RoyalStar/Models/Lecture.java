package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table
public class Lecture extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Resource resource;

    public Lecture() {}

    public Lecture(String name, Section section, Resource resource) {
        this.name = name;
        this.section = section;
        this.resource = resource;
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
                "name='" + name + '\'' +
                ", section=" + section +
                ", resource=" + resource +
                '}';
    }
}
