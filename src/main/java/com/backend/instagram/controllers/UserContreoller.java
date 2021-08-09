package com.backend.instagram.controllers;
import com.backend.instagram.domain.AuthRequest;
import com.backend.instagram.exceptions.UserAlreadyExistException;
import com.backend.instagram.models.Profile;
import com.backend.instagram.models.User;
import com.backend.instagram.services.ProfileService;
import com.backend.instagram.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")

public class UserContreoller  {

    private UserService userService;
    @Autowired
    private ProfileService profileService;


    @Autowired
    public UserContreoller(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        HashMap<String,String> res=new HashMap<>();
        try {
            return new ResponseEntity(userService.registerNewUserAccount(user), HttpStatus.OK);
        }
        catch (UserAlreadyExistException e){
            res.put("error",e.getMessage());
            return  new ResponseEntity( res,HttpStatus.OK);
        }

    }

    @GetMapping("/profile")
    public Profile getProfile(){
        String username= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return profileService.getUserProfile(username);
    }


}
