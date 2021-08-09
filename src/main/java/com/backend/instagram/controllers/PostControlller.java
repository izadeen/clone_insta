package com.backend.instagram.controllers;


import com.backend.instagram.models.Comment;
import com.backend.instagram.models.Post;
import com.backend.instagram.models.Profile;
import com.backend.instagram.services.CommentService;
import com.backend.instagram.services.LikedService;
import com.backend.instagram.services.PostService;
import com.backend.instagram.services.ProfileService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostControlller {

    @Autowired
    private PostService postService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private LikedService likedService;

    @Autowired
    private CommentService commentService;
    @GetMapping("/get_posts")
    public ResponseEntity getUserPosts(){
        String username= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Profile profile= profileService.getUserProfile(username);
        HashMap<String,Object> post;
        List<HashMap<String,Object>> posts=new ArrayList<>();

        List<Post> pposts=postService.getUserPosts(profile);
        for (Post p:pposts) {
            post=new HashMap<>();
            post.put("id", p.getId());
            post.put("file",p.getFile());
            post.put("fileType", p.getFileType());
            post.put("description",p.getDescription());
            post.put("author",p.getAuthor());
            post.put("like",this.likedService.liked(profile,p));
            post.put("likes",this.likedService.likes(p));
            post.put("timeStamp",p.getTimeStamp());
            posts.add(post);
        }
        return new ResponseEntity( posts, HttpStatus.OK);
    }

    /**
     * Don't forget to do later
     * @param id
     * @return
     */
    @GetMapping("/like/{id}")
    public Boolean like(@PathVariable Long id){
        String username= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Profile profile= profileService.getUserProfile(username);
        return likedService.LikePost(profile,id);
    }

    @PostMapping("/comment/{id}")
    public Comment comment(@PathVariable Long id, @RequestBody Comment comment){
        String username= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Profile profile= profileService.getUserProfile(username);
        return commentService.AddComment(comment,profile,id);
    }

    @GetMapping("/get_comments/{id}")
    public List<Comment> GetComments(@PathVariable Long id){
        System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        List<Comment> comments=commentService.getComments(id);
        System.out.println(comments.size());
        return comments;
    }


    @PostMapping("/add_post")
    public Post addNewPost(@RequestBody Post post){
        String username= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        Profile profile= profileService.getUserProfile(username);
        post.setAuthor(profile);
        return postService.addNewPost(post);
    }
}
