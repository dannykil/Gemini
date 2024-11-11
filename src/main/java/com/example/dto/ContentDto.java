package com.example.dto;

import java.util.List;

public class ContentDto {
    private List<PartDto> parts;

    public ContentDto() {}

    public ContentDto(List<PartDto> parts) {
        this.parts = parts;
    }

    public List<PartDto> getParts() {
        return parts;
    }

    public void setParts(List<PartDto> parts) {
        this.parts = parts;
    }

//    private Part parts;
//
//    public Content() {}
//
//    public Content(Part parts) {
//        this.parts = parts;
//    }
//
//    public Part getPart() {
//        return parts;
//    }
//
//    public void setPart(Part parts) {
//        this.parts = parts;
//    }
}