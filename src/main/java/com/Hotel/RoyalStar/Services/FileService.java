package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.File;
import jakarta.transaction.Transactional;

import java.util.List;
import com.Hotel.RoyalStar.Repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    private final FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    public File getFile(Integer fileId) {
        return fileRepository.findById(fileId).orElseThrow(
                () -> new IllegalArgumentException("File invalid")
        );
    }

    public void addFile(File file) {
        fileRepository.save(file);
    }

    public void deleteFile(Integer fileId) {
        boolean validation = fileRepository.existsById(fileId);
        if (!validation) throw new IllegalArgumentException("File not found with id: " + fileId);
        fileRepository.deleteById(fileId);
    }

    @Transactional
    public void updateFile(Integer fileId, String name, Integer size, String url, String type) {
        File file = fileRepository.findById(fileId)
                .orElseThrow(() -> new IllegalArgumentException("File not found with id: " + fileId));

        if (name != null && !name.trim().isEmpty()) file.setName(name);
        if (size != null) file.setSize(size);
        if (url != null && !url.trim().isEmpty()) file.setUrl(url);
        if (type != null) file.setType(type);

        fileRepository.save(file);
    }
}
