/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.repository;

import com.marcin.witek.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
