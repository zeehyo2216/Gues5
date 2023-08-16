package com.example.gues5.service;

import com.example.gues5.dto.Answer;
import com.example.gues5.dto.WebClientURI;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class GenerateWordService {

    //WebClient로 Random 한 단어를 가져온다.
    WebClientRequestService webClientRequestService = new WebClientRequestService();
    @Cacheable(cacheNames = "answer", key = "#userid")
    public Answer generate(){
        Answer answer = new Answer();
        WebClientURI webClientURI = new WebClientURI(
                "https://random-word-api.vercel.app/",
                "/api?words=1&length=5");
        String responseWord = webClientRequestService.get(webClientURI);

        answer.setWord(responseWord);
        return answer;
    }
}
