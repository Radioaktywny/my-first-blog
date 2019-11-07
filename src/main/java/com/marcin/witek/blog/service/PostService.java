/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.service;

import com.marcin.witek.blog.domain.Post;
import com.marcin.witek.blog.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "postService")
public class PostService implements CrudService<Post> {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post oddOrUpdate(Post post) {
       return postRepository.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post getOne(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
