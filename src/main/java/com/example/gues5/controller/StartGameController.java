package com.example.gues5.controller;

import com.example.gues5.service.GenerateWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StartGameController {
    GenerateWordService generateWordService = new GenerateWordService();
    @GetMapping("/start")
    public void start(){
        generateWord();

    }

    public void generateWord(){
            generateWordService.generate();
    }
}
