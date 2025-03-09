package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Course;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Hotel.RoyalStar.Repositories.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course getCourse(Integer courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with ID: " + courseId));
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Integer courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new IllegalArgumentException("Course not found with ID: " + courseId);
        }
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void updateCourse(Integer courseId, String description) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("The course you are trying to update does not exist"));

        if (description != null && !description.trim().isEmpty()) {
            course.setDescription(description);
        }
        courseRepository.save(course);
    }
}
