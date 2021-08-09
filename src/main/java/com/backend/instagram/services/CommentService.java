package com.backend.instagram.services;

import com.backend.instagram.models.Comment;
import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import com.backend.instagram.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostService postService;
    public Comment AddComment(Comment comment, Profile profile, Long postId){
        Post post=this.postService.getPostbyId(postId);
        comment.setAuthor(profile);
        comment.setPost(post);
        return this.commentRepo.save(comment);
    }

    public List<Comment> getComments(Long id) {
        Post post=this.postService.getPostbyId(id);
        if (post == null){
            return new ArrayList<>();
        }
        return this.commentRepo.findByPost(post);
    }
}
