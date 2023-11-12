package com.cv.generator.platform.service;

import com.cv.generator.platform.dto.JobDTO;

import java.util.List;

public interface JobService {

    List<JobDTO> getAll();

    List<JobDTO> getAllByUserId(Long id);

    JobDTO add(JobDTO jobDTO);

    void deleteById(Long id);
}
