package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Models.Text;
import com.Hotel.RoyalStar.Services.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/texts/")
public class TextController {

    private final TextService textService;

    @Autowired
    public TextController(TextService textService) {
        this.textService = textService;
    }

    @GetMapping
    public List<Text> getAllTexts() {
        return textService.getAllTexts();
    }

    @GetMapping("{text_id}")
    public Text getText(
            @PathVariable("text_id") Integer textId
    ) {
        return textService.getText(textId);
    }

    @PostMapping
    public void addText(
            @RequestBody Text text
    ) {
        textService.addText(text);
    }

    @DeleteMapping("{text_id}")
    public void deleteText(
            @PathVariable("text_id") Integer textId
    ) {
        textService.deleteText(textId);
    }

    @PutMapping("{text_id}")
    public void updateText(
            @PathVariable("text_id") Integer textId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String content
    ) {
        textService.updateText(textId, name, size, content);
    }
}
