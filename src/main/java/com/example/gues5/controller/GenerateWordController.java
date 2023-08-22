package com.example.gues5.controller;

import com.example.gues5.domain.User;
import com.example.gues5.service.GenerateWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = (User) authentication.getPrincipal();
            Long userid = user.getId();
            generateWordService.generate(userid);
    }
}
