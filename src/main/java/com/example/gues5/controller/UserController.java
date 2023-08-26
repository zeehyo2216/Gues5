package com.example.gues5.controller;

import com.example.gues5.dto.UserRegisterRequest;
import com.example.gues5.service.UserRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRegisterService userRegisterService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Long register(@Valid @RequestBody UserRegisterRequest userRegisterRequest){

        return userRegisterService.save(userRegisterRequest);
    }
}