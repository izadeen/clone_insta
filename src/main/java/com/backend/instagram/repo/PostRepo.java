package com.backend.instagram.repo;

import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    public List<Post> findPostsByAuthor(Profile profile);
}
