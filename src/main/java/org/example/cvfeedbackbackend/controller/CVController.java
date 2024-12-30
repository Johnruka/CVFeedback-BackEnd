package org.example.cvfeedbackbackend.controller;

import org.example.cvfeedbackbackend.repository.CVRepository;
import org.example.cvfeedbackbackend.entity.CV;
import org.example.cvfeedbackbackend.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv-feedback/cv")
@CrossOrigin(origins = "http://localhost:5173")
public class CVController {

    @Autowired
    private AIService service;

    @Autowired
    private CVRepository cvRepository;

    @PostMapping("/feedback")
    public ResponseEntity<String> getFeedback(@RequestBody CV cv) {
        System.out.println("cv = " + cv);
        cv.setName(cv.getName());
        cv.setEmail(cv.getEmail());
        cv.setPhone(cv.getPhone());
        cv.setWorkExperience(cv.getWorkExperience());
        cv.setEducation(cv.getEducation());
        cv.setSkills(cv.getSkills());
        cv.setFeedback(cv.getFeedback());
        String feedback = service.generateFeedback(cv.getFeedback());
        cv.setFeedback(feedback);
        cvRepository.save(cv);
        System.out.println("feedback = " + feedback);
        return ResponseEntity.ok(feedback);
    }

    @GetMapping("/feedback")
    public String chat(@RequestParam String feedback) {
        return service.generateFeedback(feedback);
    }

    @GetMapping("/reactive-feedback")
    public String reactiveChat(@RequestParam String feedback) {
        return service.generateFeedback(feedback);
    }
}
