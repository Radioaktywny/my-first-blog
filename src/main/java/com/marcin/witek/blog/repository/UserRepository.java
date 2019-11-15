/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.repository;

import com.marcin.witek.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
}
