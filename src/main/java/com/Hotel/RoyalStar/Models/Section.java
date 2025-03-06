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
public class Section extends BaseEntity{

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
                "name='" + name + '\'' +
                ", sectionOrder='" + sectionOrder + '\'' +
                ", course=" + course +
                ", lectures=" + lectures +
                '}';
    }
}
