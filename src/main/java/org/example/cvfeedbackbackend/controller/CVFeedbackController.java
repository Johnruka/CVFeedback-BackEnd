package org.example.cvfeedbackbackend.controller;

import org.example.cvfeedbackbackend.entity.CV;
import org.example.cvfeedbackbackend.repository.CVRepository;
import org.example.cvfeedbackbackend.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/cv-feedback/feedback")
@CrossOrigin(origins = "http://localhost:5173")
public class CVFeedbackController {

    @Autowired
    private AIService aiService;

    @Autowired
    private CVRepository cvRepository;

    @PostMapping
    public ResponseEntity<Map<String, String>> getFeedback(@RequestBody CV cv) {
        String feedback = aiService.generateFeedback(cv.getFeedback());

        // Save the CV entity if needed
        cv.setFeedback(feedback);
        cvRepository.save(cv);

        // Create a response map to return as JSON
        Map<String, String> response = new HashMap<>();
        response.put("feedback", feedback);

        return ResponseEntity.ok(response);
    }
}






