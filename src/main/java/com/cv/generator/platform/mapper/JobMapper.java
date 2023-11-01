package com.cv.generator.platform.mapper;

import com.cv.generator.platform.domain.Job;
import com.cv.generator.platform.dto.JobDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobMapper extends GeneralMapper<JobDTO, Job> {
}
