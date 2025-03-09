package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Lecture;
import com.Hotel.RoyalStar.Repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture getLecture(Integer lectureId) {
        return lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("Lecture unavailable")
        );
    }

    public void addLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public void deleteLecture(Integer lectureId) {
        boolean validation = lectureRepository.existsById(lectureId);
        if (!validation) throw new IllegalArgumentException("Lecture you are trying to delete is invalid");
        lectureRepository.deleteById(lectureId);
    }

    public void updateLecture(Integer lectureId, String name) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow(
                () -> new IllegalArgumentException("Invalid Lecture")
        );
        if (name != null) lecture.setName(name);
    }
}
