package com.joaovictorcmd.swiftstore.repositories;

import com.joaovictorcmd.swiftstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 04
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
