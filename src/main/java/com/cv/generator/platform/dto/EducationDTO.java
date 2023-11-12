package com.cv.generator.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationDTO implements Serializable {
    private Long id;

    private String name;

    private String country;

    private String county;

    private String diploma;

    private String profile;

    private LocalDate startDate;

    private LocalDate endDate;
}
