package com.joaovictorcmd.swiftstore.repositories;

import com.joaovictorcmd.swiftstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);
}
