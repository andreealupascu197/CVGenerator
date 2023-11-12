package com.cv.generator.platform.mapper;

import com.cv.generator.platform.domain.Education;
import com.cv.generator.platform.dto.EducationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper extends GeneralMapper<EducationDTO, Education> {
}
