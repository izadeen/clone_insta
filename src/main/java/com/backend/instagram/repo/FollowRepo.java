package com.backend.instagram.repo;

import com.backend.instagram.models.Comment;
import com.backend.instagram.models.Follow;
import com.backend.instagram.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRepo extends JpaRepository<Follow, Long> {

    List<Follow> findByFollower(Profile profile);
    List<Follow> findByFollowing(Profile profile);
    int countByFollower(Profile profile);
    int countByFollowing(Profile profile);

}
