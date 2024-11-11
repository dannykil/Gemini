package com.example.service;

import com.example.dto.ContentDto;
import com.example.entity.Gemini;
import com.example.repository.GeminiRepository;
import com.example.responseDto.GeminiResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeminiService {

    @Autowired
    private GeminiRepository conversationRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Gemini sendJsonData(ContentDto contents) {

        Gemini question = new Gemini();
        question.setAccount("Danny");
        question.setContent(contents.getParts().get(0).getText());
        question.setTimestamp(LocalDate.now() + " " + LocalTime.now().format(formatter));

        return conversationRepository.save(question);
    }

    public Gemini ResonseData(ResponseEntity<GeminiResponseDto> response) {

        Gemini answer = new Gemini();
        answer.setAccount("Gemini");
        answer.setContent(response.getBody().getCandidates().get(0).getContent().getParts().get(0).getText());
        answer.setTimestamp(LocalDate.now() + " " + LocalTime.now().format(formatter));

        return conversationRepository.save(answer);
    }

    public List<Gemini> getGemini() {
        List<Gemini> gemini = conversationRepository.findAll();
//                .orElseThrow(() -> new ServiceLogicException(ErrorCode.USER_NOT_FOUND));
//        List<Profile> profiles = findUser.getProfiles()
//                .stream().filter(p -> !(p.getProfileStatus().equals(ProfileStatus.INACTIVE)))
//                .collect(Collectors.toList());
        if (gemini.isEmpty()) {
            return new ArrayList<>();
        }
        return gemini;
    }

    public Gemini getGemini(Long id) {
        Gemini gemini = conversationRepository.findById(id).get();
        return gemini;
    }
}
