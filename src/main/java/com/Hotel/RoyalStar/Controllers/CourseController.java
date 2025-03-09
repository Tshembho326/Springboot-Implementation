package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Hotel.RoyalStar.Models.Course;
import java.util.List;

@RestController
@RequestMapping("api/courses/")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourse();
    }

    @GetMapping(path = "{course_id}")
    public Course getCourse(
            @PathVariable("course_id") Integer courseId
    ) {
         return courseService.getCourse(courseId);
    }

    @PostMapping
    public void addCourses(
            @RequestBody Course course
    ) {
        courseService.addCourse(course);
    }

    @DeleteMapping(path = "{course_id}")
    public void deleteCourse(
            @PathVariable("course_id") Integer courseId
    ) {
        courseService.deleteCourse(courseId);
    }

    @PutMapping(path = "{course_id}")
    public void updateCourse(
            @PathVariable("course_id") Integer courseId,
            @RequestParam(required = false) String description
    ) {
        courseService.updateCourse(courseId, description);
    }
}
