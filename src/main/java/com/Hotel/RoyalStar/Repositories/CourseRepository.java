package com.Hotel.RoyalStar.Repositories;

import com.Hotel.RoyalStar.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
