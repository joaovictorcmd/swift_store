package com.joaovictorcmd.swiftstore.controller;

import com.joaovictorcmd.swiftstore.exception.EmailAlreadyExistsException;
import com.joaovictorcmd.swiftstore.model.dto.LoginRequestDTO;
import com.joaovictorcmd.swiftstore.model.dto.LoginResponseDTO;
import com.joaovictorcmd.swiftstore.model.dto.UserRegisterDTO;
import com.joaovictorcmd.swiftstore.model.entity.User;
import com.joaovictorcmd.swiftstore.repository.UserRepository;
import com.joaovictorcmd.swiftstore.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var user = (User) auth.getPrincipal();
        var accessToken = tokenService.generateToken(user);

        Instant expiresAt = tokenService.getExpirationDate(accessToken);

        List<String> roles = user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity.ok(
                new LoginResponseDTO(
                        accessToken,
                        expiresAt,
                        user.getId(),
                        user.getEmail(),
                        user.getName(),
                        roles
                )
        );
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UserRegisterDTO data) {
        if (this.userRepository.findByEmail(data.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        String encryptedPassword = passwordEncoder.encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
