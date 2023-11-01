package com.cv.generator.platform.service.impl;

import com.cv.generator.platform.dto.JobDescriptionDTO;
import com.cv.generator.platform.exception.EntityNotFoundException;
import com.cv.generator.platform.mapper.JobDescriptionMapper;
import com.cv.generator.platform.repository.JobDescriptionRepository;
import com.cv.generator.platform.service.JobDescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JobDescriptionServiceImpl implements JobDescriptionService {

    private JobDescriptionRepository jobDescriptionRepository;

    private JobDescriptionMapper jobDescriptionMapper;


    @Override
    public List<JobDescriptionDTO> getAll() {
        return jobDescriptionMapper.toDTOs(jobDescriptionRepository.findAll());
    }

    @Override
    public JobDescriptionDTO getById(Long id) {
        return jobDescriptionMapper.toDTO(jobDescriptionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("job description")));
    }

    @Override
    public JobDescriptionDTO add(JobDescriptionDTO jobDescriptionDTO) {
        jobDescriptionRepository.save(jobDescriptionMapper.toEntity(jobDescriptionDTO));
        return jobDescriptionDTO;
    }

    @Override
    public void deleteById(Long id) {
        jobDescriptionRepository.deleteById(id);
    }

}
