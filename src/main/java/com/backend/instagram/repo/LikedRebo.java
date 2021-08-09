package com.backend.instagram.repo;

import com.backend.instagram.models.Liked;
import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikedRebo extends JpaRepository<Liked, Long> {
   Liked findFirstByUser(Profile user);
   Long countByLikedPost(Post post);
   boolean existsByUserAndLikedPost(Profile profile,Post likedPost);

}
