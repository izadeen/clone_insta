package com.backend.instagram.repo;

import com.backend.instagram.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

    void deleteUserById(Long id);
    Optional<Profile> findUserById(Long id);
    Profile findByUsername(String username);
}
