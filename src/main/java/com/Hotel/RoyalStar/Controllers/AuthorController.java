package com.Hotel.RoyalStar.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Hotel.RoyalStar.Services.AuthorService;
import com.Hotel.RoyalStar.Models.Author;
import java.util.List;

@RestController
@RequestMapping("api/author/")
public class AuthorController {

    public final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("all")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("{author_id}")
    public Author getAuthor(
            @PathVariable("author_id") Integer authorId
    ) {
        return authorService.getAuthor(authorId);
    }

    @PostMapping
    public void addAuthor(
            @RequestBody Author author
    ) {
        authorService.addAuthor(author);
    }

    @DeleteMapping("{author_id}")
    public void deleteAuthor(@PathVariable("author_id") Integer authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping("{author_id}")
    public void updateAuthor(
            @PathVariable("author_id") Integer authorId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
    ) {
        authorService.updateAuthor(authorId, firstName, lastName, email);
    }

}
