package com.example.gues5.service;

import com.example.gues5.domain.User;
import com.example.gues5.dto.Answer;
import com.example.gues5.dto.UserRegisterRequest;
import com.example.gues5.dto.WebClientURI;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class GenerateWordService {

    //WebClient로 Random 한 단어를 가져온다.
    WebClientRequestService webClientRequestService = new WebClientRequestService();

    @CachePut(cacheNames = "answer", key = "#userid")
    public Answer generate(Long userid){

        Answer answer = new Answer();
        WebClientURI webClientURI = new WebClientURI(
                "https://random-word-api.vercel.app/api?words=1&length=5");
        String responseWord = webClientRequestService.get(webClientURI);

        answer.setWord(responseWord);
        return answer;
    }
}
