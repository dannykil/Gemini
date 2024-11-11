package com.example.dto;

import java.util.List;

public class GeminiRequestDto {
    private List<ContentDto> contents;

    public GeminiRequestDto(List<ContentDto> contents) {
        this.contents = contents;
    }

    public List<ContentDto> getContents() {
        return contents;
    }

    public void setContents(List<ContentDto> contents) {
        this.contents = contents;
    }
}



