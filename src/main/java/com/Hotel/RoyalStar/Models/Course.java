package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table
public class Course extends BaseEntity{
    private String description;

    @ManyToMany
    @JoinTable(
            // List of the columns I want to join
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course")
    private List<Section> sections;


    public Course() {
    }

    public Course(String description, List<Author> authors, List<Section> sections) {
        this.description = description;
        this.authors = authors;
        this.sections = sections;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "description='" + description + '\'' +
                ", authors=" + authors +
                ", sections=" + sections +
                '}';
    }
}
