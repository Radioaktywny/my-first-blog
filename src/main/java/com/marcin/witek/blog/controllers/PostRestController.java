/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.controllers;

import com.marcin.witek.blog.domain.Post;
import com.marcin.witek.blog.domain.dto.PostDto;
import com.marcin.witek.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class PostRestController {
    private final PostService postService;

    public PostRestController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/post/admin")
    public Post addPost(@Valid @RequestBody PostDto post) {
        return postService.oddOrUpdate(post);
    }

    @GetMapping(path = "/post/admin")
    public List<Post> getPost() {
        return postService.getAll();
    }
}
