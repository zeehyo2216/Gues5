package com.example.gues5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TestController {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/test")
    public String test(){
        return "test OK";
    }
}
