package com.backend.instagram.services;

import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import com.backend.instagram.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public Post getPostbyId(Long postId){
        return this.postRepo.findById(postId).orElseThrow();
    }
    public List<Post> getUserPosts(Profile profile){
        return postRepo.findPostsByAuthor(profile);
    }

    public Post addNewPost(Post post) {
        return postRepo.save(post);
    }
}
