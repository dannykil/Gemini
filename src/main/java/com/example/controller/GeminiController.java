package com.example.controller;

import com.example.dto.ContentDto;
import com.example.dto.GeminiRequestDto;
import com.example.dto.PartDto;
import com.example.entity.Gemini;
import com.example.responseDto.GeminiResponseDto;
import com.example.service.GeminiService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/get")
    public String get() {
        System.out.println("List<Gemini> getGemini()");

        return "Hi, this is a API for Gemini";
    }

    @PostMapping("/sendJson")
    public ResponseEntity<GeminiResponseDto> sendJsonData(@RequestBody ContentDto contents, RestTemplate restTemplate) {
//    public ResponseEntity<String> sendJsonData(@RequestBody ContentDto contents, RestTemplate restTemplate) {

        geminiService.sendJsonData(contents);

        GeminiRequestDto request = new GeminiRequestDto(
                List.of(new ContentDto(List.of(new PartDto(contents.getParts().get(0).getText())))));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GeminiRequestDto> entity = new HttpEntity<>(request, headers);

        ResponseEntity<GeminiResponseDto> response = restTemplate.postForEntity(
                "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyD_fEUBmZ5XEmN6DO7FjJ0cqEUD7bcth5M", entity, GeminiResponseDto.class); // Replace with your actual endpoint
//        ResponseEntity<String> response = restTemplate.postForEntity(
//                "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyD_fEUBmZ5XEmN6DO7FjJ0cqEUD7bcth5M", entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            geminiService.ResonseData(response);
        }

        return response;
    }

    @GetMapping("/getGemini")
//    public ResponseEntity getGemini(@PathVariable @Positive Long userId) {
    public List<Gemini> getGemini() {
        List<Gemini> gemini = geminiService.getGemini();
        return gemini;
//        return new GeminiResponseDto(
//                GeminiResponseDto.of(mapper.entityToGeminiResponseDto(geminis)),
//                HttpStatus.OK);
    }

    @GetMapping("/getGemini/{id}")
    public Gemini getGemini(@PathVariable Long id) {
        Gemini gemini = geminiService.getGemini(id);

        return gemini;
    }
}