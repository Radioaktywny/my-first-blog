/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.service;

import com.marcin.witek.blog.domain.Post;
import com.marcin.witek.blog.domain.dto.PostInfo;
import com.marcin.witek.blog.repository.CategoryRepository;
import com.marcin.witek.blog.repository.PostRepository;
import com.marcin.witek.blog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "postService")
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public PostInfo oddOrUpdate(PostInfo postInfo) {
        if (Objects.isNull(postInfo.getId())) {
            return createPost(postInfo);
        } else {
            return updatePost(postInfo);
        }
    }

    private PostInfo updatePost(PostInfo postInfo) {
        Optional<Post> post = postRepository.findById(postInfo.getId());
        post.ifPresent(p -> updatePost(p, postInfo));
        return postInfo;
    }

    private void updatePost(Post post, PostInfo postInfo) {
        fillPostWithDataFromPostInfo(postInfo, post);

    }

    private PostInfo createPost(PostInfo postInfo) {
        Post post = createPostFromDTO(postInfo);
        postRepository.save(post);
        return postInfo;
    }

    private Post createPostFromDTO(PostInfo postInfo) {
        Post post = new Post();
        fillPostWithDataFromPostInfo(postInfo, post);
        return post;
    }

    private void fillPostWithDataFromPostInfo(PostInfo postInfo, Post post) {
        post.setAuthor(userRepository.findAllByName("nuub").get(0));//todo
        post.setCategory(categoryRepository.findAll().get(0));//todo
        post.setDate(Date.from(Instant.now()));
        post.setContent(postInfo.getText());
        post.setTitle(postInfo.getTitle());
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
