package org.example.cvfeedbackbackend.repository;

import org.example.cvfeedbackbackend.entity.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CVRepository extends JpaRepository<CV, Long> {
}
