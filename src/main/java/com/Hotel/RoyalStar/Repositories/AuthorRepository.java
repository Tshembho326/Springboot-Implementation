package com.Hotel.RoyalStar.Repositories;

import com.Hotel.RoyalStar.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
