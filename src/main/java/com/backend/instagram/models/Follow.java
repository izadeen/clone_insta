package com.backend.instagram.models;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    private Profile follower;

    @ManyToOne
    @JoinColumn(name = "following_id", referencedColumnName = "id")
    private Profile following;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getFollower() {
        return follower;
    }

    public void setFollower(Profile follower) {
        this.follower = follower;
    }

    public Profile getFollowing() {
        return following;
    }

    public void setFollowing(Profile following) {
        this.following = following;
    }
}
