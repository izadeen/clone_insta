package com.backend.instagram.repo;

import com.backend.instagram.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    User findUserByEmail(String email);
    Optional <User> findByUsername(String username);

}
