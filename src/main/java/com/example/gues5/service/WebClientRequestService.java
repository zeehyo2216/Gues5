package com.example.gues5.service;

import com.example.gues5.dto.WebClientURI;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class WebClientRequestService {
    public String get(WebClientURI webClientURI) {
        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl(webClientURI.getBaseUrl())
                        .build();

        String response =
                webClient
                        .get()
                        .uri(uriBuilder ->
                                uriBuilder
                                        .path("")
                                        //.queryParam("code", code)
                                        .build()) //webClientURI.getParams() 들어가는 곳
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();
        return response;
    }
}
