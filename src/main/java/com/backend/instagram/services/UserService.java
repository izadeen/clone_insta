package com.backend.instagram.services;

import com.backend.instagram.exceptions.UserAlreadyExistException;
import com.backend.instagram.models.Profile;
import com.backend.instagram.models.User;

import com.backend.instagram.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public User registerNewUserAccount(User user) throws UserAlreadyExistException {
        if (emailExist(user.getEmail())) {
            throw new UserAlreadyExistException(
                     user.getEmail()+" email already exist");
        }

        if (userNameExist(user.getUsername())) {
            throw new UserAlreadyExistException(
                     user.getUsername()+" username already exist");
        }

        String pass=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(pass);
        Profile profile =new Profile();
        user.setProfile(profile);
        profile.setUsername(user.getUsername());
        User newUser=userRepo.save(user);

        return newUser;
    }
    private boolean emailExist(String email) {
        return userRepo.findUserByEmail(email) != null;
    }
    private boolean userNameExist(String userName) {
        return userRepo.findByUsername(userName).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username))
                );
    }
}
