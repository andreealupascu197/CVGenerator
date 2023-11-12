package com.cv.generator.platform.service.impl;

import com.cv.generator.platform.dto.JobDTO;
import com.cv.generator.platform.mapper.JobMapper;
import com.cv.generator.platform.repository.JobRepository;
import com.cv.generator.platform.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    private JobMapper jobMapper;

    @Override
    public List<JobDTO> getAll() {
        return jobMapper.toDTOs(jobRepository.findAll());
    }

    @Override
    public List<JobDTO> getAllByUserId(Long id) {
        return jobMapper.toDTOs(jobRepository.findByUserId(id));
    }

    @Override
    public JobDTO add(JobDTO jobDTO) {
        jobRepository.save(jobMapper.toEntity(jobDTO));
        return jobDTO;
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }

}
