package com.example.gues5.dto;

import lombok.*;

@Data
@RequiredArgsConstructor
public class WebClientURI {
    @NonNull
    private String baseUrl;
    private String path;
    private Object params;
}
