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
@RequestMapping("/api/cv-feedback/cv")
@CrossOrigin(origins = "http://localhost:5173")
public class CVController {

    @Autowired
    private AIService service;

    @Autowired
    private CVRepository cvRepository;

    @PostMapping("/feedback")
    public ResponseEntity<Map<String, String>> getFeedback(@RequestBody CV cv) {
        System.out.println("cv = " + cv);

        // Presumably, service generates feedback from the CV's feedback field
        String feedback = service.generateFeedback(cv.getFeedback());

        // Update and save the CV entity
        cv.setFeedback(feedback);
        cvRepository.save(cv);

        // Create a response map
        Map<String, String> response = new HashMap<>();
        response.put("feedback", feedback);

        System.out.println("getFeedback = " + feedback);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/feedback")
    public ResponseEntity<Map<String, String>> chat(@RequestParam String feedback) {
        String generatedFeedback = service.generateFeedback(feedback);

        Map<String, String> response = new HashMap<>();
        response.put("feedback", generatedFeedback);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/reactive-feedback")
    public ResponseEntity<Map<String, String>> reactiveChat(@RequestParam String feedback) {
        String generatedFeedback = service.generateFeedback(feedback);

        Map<String, String> response = new HashMap<>();
        response.put("feedback", generatedFeedback);

        return ResponseEntity.ok(response);
    }
}



