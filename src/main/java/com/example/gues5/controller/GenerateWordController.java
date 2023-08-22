package com.example.gues5.controller;

import com.example.gues5.service.GenerateWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GenerateWordController {
    GenerateWordService generateWordService = new GenerateWordService();
    @PostMapping("/answer")
    public void generateWord(){
            generateWordService.generate();
    }
}
