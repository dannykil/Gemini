package com.example.repository;

import com.example.entity.Gemini;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeminiRepository extends JpaRepository<Gemini, Long> {
    // You can add custom query methods here if needed
}