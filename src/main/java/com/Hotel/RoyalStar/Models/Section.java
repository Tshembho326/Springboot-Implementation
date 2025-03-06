package com.Hotel.RoyalStar.Models;


import jakarta.persistence.*;

@Entity
@Table
public class Section {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "section_generator"
    )
    @SequenceGenerator(
            name = "sequence_generator",
            sequenceName = "sequence_generator",
            allocationSize = 1
    )
    private Integer id;
    private String name;
    private String order;

    public Section() {}

    public Section(String name, String order) {
        this.name = name;
        this.order = order;
    }

    public Section(int id, String name, String order) {
        this.id = id;
        this.name = name;
        this.order = order;
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

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
