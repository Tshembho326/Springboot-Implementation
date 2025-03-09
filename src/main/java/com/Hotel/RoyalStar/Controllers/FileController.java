package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Hotel.RoyalStar.Models.File;
import java.util.List;

@RestController
@RequestMapping("/api/files/")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public List<File> getAllFiles() {
        return fileService.getAllFiles();
    }

    @GetMapping("{file_id}")
    public File getFile(
            @PathVariable("lecture_id") Integer fileId
    ) {
        return fileService.getFile(fileId);
    }

    @PostMapping
    public void addFile(File file) {
        fileService.addFile(file);
    }

    @DeleteMapping("{file_id}")
    public void deleteFile(
            @PathVariable("file_id") Integer fileId
    ) {
        fileService.deleteFile(fileId);
    }

    @PutMapping("{file_id}")
    public void updateFile(
            @PathVariable("file_id") Integer fileId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) String type
    ) {
        fileService.updateFile(fileId, name, size, url, type);
    }
}
