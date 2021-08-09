package com.backend.instagram.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Liked {
    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")

    private Profile user;

    @OneToOne
    @JoinColumn(name = "Post_id", referencedColumnName = "id")

   private Post likedPost;

    public void setUser(Profile profile) {
        this.user=profile;
    }

    public long getId() {
        return id;
    }

    public Profile getUser() {
        return user;
    }

    public Post getLikedPost() {
        return likedPost;
    }

    public void setLikedPost(Post likedPost) {
        this.likedPost = likedPost;
    }

    public void setId(long id) {
        this.id = id;
    }
}
