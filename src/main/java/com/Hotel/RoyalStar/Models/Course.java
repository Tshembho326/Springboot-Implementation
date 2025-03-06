package com.Hotel.RoyalStar.Models;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Builder
@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "course_sequence"
    )
    private Integer id;

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
    List<Author> authors;

    @OneToMany(mappedBy = "course")
    List<Section> sections;


    public Course() {
    }

    public Course(String description, List<Author> authors, List<Section> sections) {
        this.description = description;
        this.authors = authors;
        this.sections = sections;
    }

    public Course(int id, String description, List<Author> authors, List<Section> sections) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

}
