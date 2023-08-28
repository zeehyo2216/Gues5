package com.example.gues5.controller;

import com.example.gues5.domain.User;
import com.example.gues5.dto.JwtToken;
import com.example.gues5.dto.UserRegisterRequest;
import com.example.gues5.model.JwtTokenProvider;
import com.example.gues5.repository.UserRepository;
import com.example.gues5.service.UserRegisterService;
import com.example.gues5.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRegisterService userRegisterService;
    private final UserService userService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Long register(@Valid @RequestBody UserRegisterRequest userRegisterRequest){

        return userRegisterService.save(userRegisterRequest);
    }

    @PostMapping("/login")
    public JwtToken login(@RequestBody Map<String, String> userRequest) {
        String email = userRequest.get("email");
        String password = userRequest.get("password");
        JwtToken jwtToken = userService.login(email, password);
        return jwtToken;
    }
}
