package com.cv.generator.platform.service.impl;

import com.cv.generator.platform.domain.Education;
import com.cv.generator.platform.domain.Job;
import com.cv.generator.platform.domain.User;
import com.cv.generator.platform.exception.EntityNotFoundException;
import com.cv.generator.platform.pdf.PdfGenerator;
import com.cv.generator.platform.repository.EducationRepository;
import com.cv.generator.platform.repository.JobRepository;
import com.cv.generator.platform.repository.UserRepository;
import com.cv.generator.platform.service.PdfGeneratorService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PdfGeneratorServiceImpl implements PdfGeneratorService {

    private UserRepository userRepository;

    private JobRepository jobRepository;

    private EducationRepository educationRepository;

    private PdfGenerator pdfGenerator;

    public String generateCv(Long userId) throws DocumentException, IOException {
        try {
            User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("user"));
            List<Job> jobs = jobRepository.findByUserId(user.getId());
            List<Education> educations = educationRepository.findByUserId(user.getId());

            if (jobs.isEmpty() || educations.isEmpty()) {
                return "No job or education records found for the user.";
            }

            pdfGenerator.generateCV(user, jobs, educations);
            return "CV generated successfully.";
        } catch (Exception e) {
            return "CV generation failed: " + e.getMessage();
        }
    }
}