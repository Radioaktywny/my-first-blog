/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.service;

import com.marcin.witek.blog.domain.Post;
import com.marcin.witek.blog.domain.dto.PostDto;
import com.marcin.witek.blog.repository.AuthorRepository;
import com.marcin.witek.blog.repository.CategoryRepository;
import com.marcin.witek.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

@Service(value = "postService")
public class PostService {

    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    public Post oddOrUpdate(PostDto postDto) {
        Post post = new Post();
        post.setAuthor(authorRepository.findAll().get(0));
        post.setCategory(categoryRepository.findAll().get(0));
        post.setDate(Date.from(Instant.now()));
        post.setText(postDto.getText());
        post.setTitle(postDto.getTitle());
        return postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public Post getOne(Long id) {
        return postRepository.getOne(id);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
