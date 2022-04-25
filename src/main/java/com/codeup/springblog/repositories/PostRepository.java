package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post getPostById(long id);
}
