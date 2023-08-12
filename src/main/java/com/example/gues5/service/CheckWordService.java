package com.example.gues5.service;


import com.example.gues5.dto.Answer;
import org.springframework.stereotype.Service;

@Service
public class CheckWordService {
    private Answer answer = new Answer(); //api 요청하는 서비스 주입
    public int[] checkWord(String guess){
        int[] checkarray = new int[5];
        String word = answer.getWord();



        return checkarray;
    }
}
