package com.example.demo.controller;

import com.example.demo.entity.Posts;
import com.example.demo.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

    @PostMapping
    public Posts createPost(@RequestBody Posts posts) {
        return postsRepository.save(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        Optional<Posts> post = postsRepository.findById(id);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable Long id, @RequestBody Posts postDetails) {
        Optional<Posts> optionalPost = postsRepository.findById(id);

        if (optionalPost.isPresent()) {
            Posts post = optionalPost.get();
            post.setName(postDetails.getName());
            post.setDescription(postDetails.getDescription());
            return ResponseEntity.ok(postsRepository.save(post));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        if (postsRepository.existsById(id)) {
            postsRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Phương thức viewPosts
    @GetMapping("/view")
    public ResponseEntity<List<Posts>> viewPosts(@RequestParam String name) {
        List<Posts> posts = postsRepository.findByNameContainingIgnoreCase(name);
        if (posts.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(posts);
        }
    }
}
