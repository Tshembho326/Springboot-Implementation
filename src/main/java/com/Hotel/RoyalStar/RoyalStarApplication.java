package com.Hotel.RoyalStar;

import com.Hotel.RoyalStar.Models.Author;
import com.Hotel.RoyalStar.Repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.Authenticator;

@SpringBootApplication(scanBasePackages = "com.Hotel.RoyalStar")
public class RoyalStarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoyalStarApplication.class, args);
	}

}

