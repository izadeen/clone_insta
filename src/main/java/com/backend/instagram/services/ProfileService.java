package com.backend.instagram.services;

import com.backend.instagram.models.Profile;
import com.backend.instagram.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProfileService {
    @Autowired
    private ProfileRepo profileRepo;

    public Profile getUserProfile(String username){
        return profileRepo.findByUsername(username);
    }
}
