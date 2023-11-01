package com.cv.generator.platform.mapper;

import com.cv.generator.platform.domain.JobDescription;
import com.cv.generator.platform.dto.JobDescriptionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobDescriptionMapper extends GeneralMapper<JobDescriptionDTO, JobDescription> {
}
