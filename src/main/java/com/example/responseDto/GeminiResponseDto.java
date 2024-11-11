package com.example.responseDto;

import com.example.dto.CandidatesDto;

import java.util.List;

public class GeminiResponseDto {
    private List<CandidatesDto> candidates;

    public GeminiResponseDto() {}

    public GeminiResponseDto(List<CandidatesDto> candidates) {
        this.candidates = candidates;
    }

    public List<CandidatesDto> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<CandidatesDto> candidates) {
        this.candidates = candidates;
    }

//    private Candidates candidates;
//
//    public Response() {}
//
//    public Response(Candidates candidates) {
//        this.candidates = candidates;
//    }
//
//    public Candidates getCandidates() {
//        return candidates;
//    }
//
//    public void setCandidates(Candidates candidates) {
//        this.candidates = candidates;
//    }
}