package com.example.gues5.dto;

import lombok.Getter;

@Getter
public enum CacheType {

    ANSWER("answer", 24*60*60, 10000);

    CacheType(String cacheName, int expiredAfterWrite, int maximumSize) {
        this.cacheName = cacheName;
        this.expiredAfterWrite = expiredAfterWrite;
        this.maximumSize = maximumSize;
    }

    private String cacheName;
    private int expiredAfterWrite;
    private int maximumSize;

}
