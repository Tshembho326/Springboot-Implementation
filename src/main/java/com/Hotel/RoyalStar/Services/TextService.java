package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Text;
import com.Hotel.RoyalStar.Repositories.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextService {

    private final TextRepository textRepository;

    @Autowired
    public TextService(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public List<Text> getAllTexts() {
        return textRepository.findAll();
    }

    public Text getText(Integer textId) {
        return textRepository.findById(textId).orElseThrow(
                () -> new IllegalArgumentException("Text not found with ID: " + textId)
        );
    }

    public void addText(Text text) {
        textRepository.save(text);
    }

    public void deleteText(Integer textId) {
        boolean validation = textRepository.existsById(textId);
        if (!validation) throw new IllegalArgumentException("Text not found with ID: " + textId);
        textRepository.deleteById(textId);
    }

    public void updateText(Integer textId, String name, Integer size, String content) {
        Text text = textRepository.findById(textId).orElseThrow(
                () -> new IllegalArgumentException("Text not found with ID: " + textId)
        );
        if (name != null) text.setName(name);
        if (size != null) text.setSize(size);
        if (content != null) text.setContent(content);

        textRepository.save(text);
    }
}
