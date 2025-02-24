package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.exception.UserNotAuthenticatedException;
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

    protected UserDetails authenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            throw new UserNotAuthenticatedException("User is not authenticated");
        }

        var principal = authentication.getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails;
        }

        throw new UserNotAuthenticatedException("Unexpected authentication principal type");
    }
}
