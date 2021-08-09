package com.backend.instagram.repo;

import com.backend.instagram.models.Comment;
import com.backend.instagram.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    public List<Comment> findByPost(Post post);

}
