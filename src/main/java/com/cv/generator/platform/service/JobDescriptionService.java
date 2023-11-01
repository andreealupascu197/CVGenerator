package com.cv.generator.platform.service;

import com.cv.generator.platform.dto.JobDescriptionDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public interface JobDescriptionService {
    List<JobDescriptionDTO> getAll();

    JobDescriptionDTO getById(Long id);

    JobDescriptionDTO add(JobDescriptionDTO jobDescriptionDTO);

    void deleteById(Long id);



}