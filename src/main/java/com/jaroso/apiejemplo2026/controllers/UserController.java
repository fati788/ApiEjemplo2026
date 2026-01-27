package com.jaroso.apiejemplo2026.controllers;

import com.jaroso.apiejemplo2026.dtos.TaskDto;
import com.jaroso.apiejemplo2026.dtos.UserCreateDto;
import com.jaroso.apiejemplo2026.dtos.UserDto;
import com.jaroso.apiejemplo2026.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getUserByUserNAme(@PathVariable String userName){
        return userService.findByUserNAme(userName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUer(user));
    }


}
