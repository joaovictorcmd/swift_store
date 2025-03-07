package com.joaovictorcmd.swiftstore.model.repository;

import com.joaovictorcmd.swiftstore.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
