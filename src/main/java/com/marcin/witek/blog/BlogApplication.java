/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog;

import com.marcin.witek.blog.domain.Author;
import com.marcin.witek.blog.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
		return (args -> {
			Author entity = new Author();
			entity.setName("author 1");
			authorRepository.save(entity);


			authorRepository.findAll().forEach(System.out::println);
		});
    }

}
