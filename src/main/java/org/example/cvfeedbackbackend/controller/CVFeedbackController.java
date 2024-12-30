package org.example.cvfeedbackbackend.controller;

import org.example.cvfeedbackbackend.entity.CV;
import org.example.cvfeedbackbackend.repository.CVRepository;
import org.example.cvfeedbackbackend.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cv-feedback")
public class CVFeedbackController {

    @Autowired
    private AIService aiService;

    @Autowired
    private CVRepository cvRepository;

    @PostMapping("/feedback")
    public ResponseEntity<String> getFeedback(@RequestBody CV cv) {

        cv.setName(cv.getName());
        cv.setWorkExperience(cv.getWorkExperience());
        cv.setEducation(cv.getEducation());
        cv.setSkills(cv.getSkills());
        cv.setFeedback(cv.getFeedback());

        String feedback = aiService.generateFeedback(cv.getFeedback());
        cv.setFeedback(feedback);
        cvRepository.save(new CV());
        return ResponseEntity.ok(feedback);



    }

}


