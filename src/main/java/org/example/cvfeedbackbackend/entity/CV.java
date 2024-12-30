package org.example.cvfeedbackbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(columnDefinition = "TEXT")
    private String workExperience;
    @Column(columnDefinition = "TEXT")
    private String education;
    @Column(columnDefinition = "TEXT")
    private String skills;
    private String feedback;


    public CV(String name, String workExperience, String education, String skills) {
        this.name = name;
        this.workExperience = workExperience;
        this.education = education;
        this.skills = skills;
    }
}