package com.example.gues5.service;

import com.example.gues5.dto.Answer;
import com.example.gues5.dto.WebClientURI;
import org.springframework.stereotype.Service;

@Service
public class GenerateWordService {
    public void generate(){
        Answer answer = new Answer();
        //WebClient로 Random 한 단어를 가져온다.
        WebClientRequestService webClientRequestService = new WebClientRequestService();
        WebClientURI webClientURI = new WebClientURI(
                "https://random-word-api.vercel.app/",
                "/api?words=1&length=5");
        String responseWord = webClientRequestService.get(webClientURI);

        answer.setWord(responseWord);
    }
}
