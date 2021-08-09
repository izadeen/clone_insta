package com.backend.instagram.services;


import com.backend.instagram.models.Liked;
import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import com.backend.instagram.repo.LikedRebo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LikedService {

    @Autowired
    private LikedRebo likedRebo;

    @Autowired
    private PostService postService;

    public boolean liked(Profile profile, Post post) {
        return this.likedRebo.existsByUserAndLikedPost(profile,post);
    }

    public Boolean LikePost(Profile profile, Long postId){
        Post post=this.postService.getPostbyId(postId);
        Liked liked;
        if(this.likedRebo.existsByUserAndLikedPost(profile,post)) {
            liked = this.likedRebo.findFirstByUser(profile);
            this.likedRebo.delete(liked);
            return Boolean.FALSE;
        }
        liked=new Liked();
        liked.setUser(profile);
        liked.setLikedPost(post);
        this.likedRebo.save(liked);
        return true;
    }

    public Long likes(Post p) {
        return this.likedRebo.countByLikedPost(p);
    }
}
