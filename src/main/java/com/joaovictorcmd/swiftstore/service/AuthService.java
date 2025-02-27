package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.exception.ForbiddenException;
import com.joaovictorcmd.swiftstore.exception.UserNotAuthenticatedException;
import com.joaovictorcmd.swiftstore.model.entity.User;
import com.joaovictorcmd.swiftstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    protected User authenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser") || authentication.getPrincipal() == null) {
            throw new UserNotAuthenticatedException("Unauthenticated user");
        }
        String username = authentication.getName();

        return userRepository.findByEmail(username).orElseThrow(
                () -> new UserNotAuthenticatedException("Invalid user")
        );
    }

    public void validateSelfOrAdmin(Long userId) {
        User me = authenticated();
        if ((!me.hasRole("ADMIN")) && (!me.getId().equals(userId))) {
            throw new ForbiddenException("Access denied");
        }
    }
}
