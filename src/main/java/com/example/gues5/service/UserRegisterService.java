package com.example.gues5.service;

import com.example.gues5.domain.User;
import com.example.gues5.dto.UserRegi;
import com.example.gues5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserRegisterService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(UserRegi userRegi) {
        return userRepository.save(User.builder()
                .email(userRegi.getEmail())
                .password(bCryptPasswordEncoder.encode(userRegi.getPassword()))
                .nickname(userRegi.getNickname())
                .build()).getId();
    }
}
