/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.repository;

import com.marcin.witek.blog.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findOneByTitle(String title);
}
