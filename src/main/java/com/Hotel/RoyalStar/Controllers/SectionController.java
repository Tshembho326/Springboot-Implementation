package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Hotel.RoyalStar.Models.Section;
import java.util.List;

@RestController
@RequestMapping("/api/sections/")
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("{section_id}")
    public Section getSection(
            @PathVariable("section_id") Integer sectionId
    ) {
        return sectionService.getSection(sectionId);
    }

    @PostMapping
    public void addSection(
            @RequestBody Section section
    ) {
        sectionService.addSection(section);
    }

    @DeleteMapping("{section_id}")
    public void deleteSection(
            @PathVariable("section_id") Integer sectionId
    ) {
        sectionService.deleteSection(sectionId);
    }

    @PutMapping("{section_id}")
    public void updateSection(
            @PathVariable("section_id") Integer sectionId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String order
    ) {
        sectionService.updateStudent(sectionId, name, order);
    }
}
