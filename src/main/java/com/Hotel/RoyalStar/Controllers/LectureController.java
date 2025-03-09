package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Services.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Hotel.RoyalStar.Models.Lecture;
import java.util.List;

@RestController
@RequestMapping("api/lectures/")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("{lecture_id}")
    public Lecture getLecture(
            @PathVariable("lecture_id")Integer lectureId
    ) {
        return lectureService.getLecture(lectureId);
    }

    @PostMapping
    public void addLecture(
            @RequestBody Lecture lecture
    ) {
        lectureService.addLecture(lecture);
    }

    @DeleteMapping("{lecture_id}")
    public void deleteLecture(
            @PathVariable("lecture_id") Integer lectureId
    ) {
        lectureService.deleteLecture(lectureId);
    }

    @PutMapping("{lecture_id}")
    public void updateLecture(
            @PathVariable("lecture_id") Integer lectureId,
            @RequestParam(required = false) String name
    ) {
        lectureService.updateLecture(lectureId, name);
    }
}
