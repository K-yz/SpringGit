package com.example.demo.repository;

import com.example.demo.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByNameContainingIgnoreCase(String name);
}
