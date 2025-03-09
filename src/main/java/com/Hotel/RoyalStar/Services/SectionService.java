package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Section;
import com.Hotel.RoyalStar.Repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    public Section getSection(Integer sectionId) {
        return sectionRepository.findById(sectionId).orElseThrow(
                () -> new IllegalArgumentException("The section is invalid")
        );
    }

    public void addSection(Section section) {
        sectionRepository.save(section);
    }

    public void deleteSection(Integer sectionId) {
        boolean validation = sectionRepository.existsById(sectionId);

        if (!validation) throw new IllegalArgumentException("The section you're trying to delete is invalid");
        sectionRepository.deleteById(sectionId);
    }

    public void updateStudent(Integer sectionId, String name, String order) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(
                () -> new IllegalArgumentException("The section you're trying to update is invalid")
        );
        if (name != null) section.setName(name);
        if (order != null) section.setSectionOrder(order);
    }
}
