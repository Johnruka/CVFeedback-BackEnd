package org.example.cvfeedbackbackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    @Column(columnDefinition = "TEXT")
    private String workExperience;
    @Column(columnDefinition = "TEXT")
    private String education;
    @Column(columnDefinition = "TEXT")
    private String skills;
    private String feedback;


    public CV(String name, String email, String phone, String workExperience, String education, String skills, String feedback) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.workExperience = workExperience;
        this.education = education;
        this.skills = skills;
        this.feedback = feedback;
    }
}