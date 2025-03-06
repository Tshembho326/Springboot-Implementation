package com.Hotel.RoyalStar.Models;


import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Builder
@Entity
@Table
public class Section {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "section_generator"
    )
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "sequence_generator",
            allocationSize = 1
    )
    private Integer id;
    private String name;
    private String sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

    public Section() {}

    public Section(String name, String sectionOrder, Course course, List<Lecture> lectures) {
        this.name = name;
        this.sectionOrder = sectionOrder;
        this.course = course;
        this.lectures = lectures;
    }

    public Section(int id, String name, String sectionOrder, Course course, List<Lecture> lectures) {
        this.id = id;
        this.name = name;
        this.sectionOrder = sectionOrder;
        this.course = course;
        this.lectures = lectures;
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

    public String getSectionOrder() {
        return sectionOrder;
    }

    public void setSectionOrder(String sectionOrder) {
        this.sectionOrder = sectionOrder;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sectionOrder='" + sectionOrder + '\'' +
                '}';
    }
}
