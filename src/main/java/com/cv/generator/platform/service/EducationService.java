package com.cv.generator.platform.service;

import com.cv.generator.platform.dto.EducationDTO;

import java.util.List;

public interface EducationService {

    List<EducationDTO> getAll();

    List<EducationDTO> getByUserId(Long id);

    EducationDTO add(EducationDTO educationDTO);

    void deleteById(Long id);
}
