package com.backend.instagram.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {


    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false,unique = true)
    @Setter
    @Getter
    private String username;
    @Setter
    @Getter
    private String name="";
    @Setter
    @Getter
    private String pio="";
    @Setter
    @Getter
    private String profileImage="https://firebasestorage.googleapis.com/v0/b/instagram-3f56a.appspot.com/o/profile%2FUnknown.png?alt=media&token=895ab41a-9423-45a1-a937-4c15b3760898";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @Setter
    @Getter
    private User user;

    






    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
