package com.backend.instagram.services;


import com.backend.instagram.models.Follow;
import com.backend.instagram.models.Profile;
import com.backend.instagram.repo.FollowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FollowService {
    @Autowired
    private FollowRepo followRepo;

    public List<Follow> getFollowers(Profile profile){
        return this.followRepo.findByFollowing(profile);
    }

    public List<Follow> getFollowing(Profile profile){
        return this.followRepo.findByFollower(profile);
    }

    public int getNumberOfFollowers(Profile profile){
        return this.followRepo.countByFollowing(profile);
    }

    public int getNumberOfFollowing(Profile profile){
        return this.followRepo.countByFollower(profile);
    }

}
