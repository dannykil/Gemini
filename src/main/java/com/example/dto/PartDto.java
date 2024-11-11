package com.example.dto;

public class PartDto {
    private String text;

    public PartDto() {}

    public PartDto(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}