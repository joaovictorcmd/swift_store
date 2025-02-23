package com.joaovictorcmd.swiftstore.repository;

import com.joaovictorcmd.swiftstore.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
