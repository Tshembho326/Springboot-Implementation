package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Author;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Hotel.RoyalStar.Repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorService {
    public final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("The author is not found"));
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Integer authorId) {
        if (!authorRepository.existsById(authorId))
            throw new IllegalArgumentException("The author with that Id is invalid");
        authorRepository.deleteById(authorId);
    }

    @Transactional
    public void updateAuthor(Integer authorId, String firstName, String lastName, String email) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + authorId));

        if (firstName != null && !firstName.trim().isEmpty()) author.setFirstName(firstName);

        if (lastName != null && !lastName.trim().isEmpty()) author.setLastName(lastName);

        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) author.setEmail(email);
         else if (email != null) throw new IllegalArgumentException("Invalid email format: " + email);
         authorRepository.save(author);
    }
}