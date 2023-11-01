package com.cv.generator.platform.service.impl;

import com.cv.generator.platform.dto.EducationDTO;
import com.cv.generator.platform.mapper.EducationMapper;
import com.cv.generator.platform.repository.EducationRepository;
import com.cv.generator.platform.service.EducationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class EducationServiceImpl implements EducationService {

    private EducationRepository educationRepository;

    private EducationMapper educationMapper;

    @Override
    public List<EducationDTO> getAll() {
        return educationMapper.toDTOs(educationRepository.findAll());
    }

    @Override
    public List<EducationDTO> getByUserId(Long id) {
        return educationMapper.toDTOs(educationRepository.findAllById(Collections.singleton(id)));
    }

    @Override
    public EducationDTO add(EducationDTO educationDTO) {
        educationRepository.save(educationMapper.toEntity(educationDTO));
        return educationDTO;
    }

    @Override
    public void deleteById(Long id) {
        educationRepository.deleteById(id);
    }
}
