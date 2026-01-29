package com.jaroso.apiejemplo2026.services;


import com.jaroso.apiejemplo2026.dtos.AuthDto;
import com.jaroso.apiejemplo2026.dtos.UserCreateDto;
import com.jaroso.apiejemplo2026.entities.User;
import com.jaroso.apiejemplo2026.repositories.UserRepository;
import com.jaroso.apiejemplo2026.security.UserAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public AuthDto save(UserCreateDto userDTO) {
        User user = new User(
                null,
                userDTO.userName(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ)
        );
        this.repository.save(user);
        return null;
    }
}
