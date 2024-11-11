package com.example.dto;

public class CandidatesDto {
//    private List<Content> content;
//
//    public Candidates() {}
//
//    public Candidates(List<Content> content) {
//        this.content = content;
//    }
//
//    public List<Content> getContent() {
//        return content;
//    }
//
//    public void setContents(List<Content> content) {
//        this.content = content;
//    }

    private ContentDto content;

    public CandidatesDto() {}

    public CandidatesDto(ContentDto content) {
        this.content = content;
    }

    public ContentDto getContent() {
        return content;
    }

    public void setContents(ContentDto content) {
        this.content = content;
    }
}