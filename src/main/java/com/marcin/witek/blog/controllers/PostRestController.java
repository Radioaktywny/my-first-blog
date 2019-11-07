/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.controllers;

import com.marcin.witek.blog.domain.Post;
import com.marcin.witek.blog.service.CrudService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/rest")
public class PostRestController {
    private final CrudService<Post> postService;

    public PostRestController(CrudService<Post> postService) {
        this.postService = postService;
    }

    @PostMapping(path = "/post/admin")
    public Post addPost(@Valid @RequestBody Post post) { //replace this one with PostDto and in service do the same (no logic here).
        return postService.oddOrUpdate(post);
    }

    @GetMapping(path = "/post/admin")
    public List<Post> getPost() {
        return postService.getAll();
    }
}
