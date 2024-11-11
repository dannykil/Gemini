package com.example.mapper;

import com.example.dto.ContentDto;
import com.example.entity.Gemini;
//import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//@Mapper
public interface GeminiMapper {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    default Gemini dtoToEntity(ContentDto contentDto) {
        if ( contentDto == null ) {
            return null;
        }

        Gemini question = new Gemini();

        question.setAccount("Danny");
        question.setContent(contentDto.getParts().get(0).getText());
        question.setTimestamp(LocalDate.now() + " " + LocalTime.now().format(formatter));

        return question;
    }
}
