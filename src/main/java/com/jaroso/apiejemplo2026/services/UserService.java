package com.jaroso.apiejemplo2026.services;

import com.jaroso.apiejemplo2026.dtos.TaskCreateDto;
import com.jaroso.apiejemplo2026.dtos.TaskDto;
import com.jaroso.apiejemplo2026.dtos.UserCreateDto;
import com.jaroso.apiejemplo2026.dtos.UserDto;
import com.jaroso.apiejemplo2026.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUserNAme(String userName);
    UserDetails loadUserByUsername(String username);
    UserDto saveUer(UserCreateDto userCreateDto);
    public void seleteUser(Long id);

}
