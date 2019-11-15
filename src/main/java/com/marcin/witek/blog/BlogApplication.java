/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog;

import com.marcin.witek.blog.domain.Role;
import com.marcin.witek.blog.domain.User;
import com.marcin.witek.blog.domain.Category;
import com.marcin.witek.blog.repository.UserRepository;
import com.marcin.witek.blog.repository.CategoryRepository;
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
    public CommandLineRunner commandLineRunner(UserRepository userRepository, CategoryRepository categoryRepository) {
		return (args -> {
			User entity = new User();
			entity.setName("admin");
			entity.setPassword("{noop}admin");
			entity.setRole(Role.ADMIN);
			userRepository.save(entity);
            Category category = new Category();
            category.setTitle("Category 1");
            category.setDescription("Super description");
            categoryRepository.save(category);


			userRepository.findAll().forEach(System.out::println);
		});
    }

}
