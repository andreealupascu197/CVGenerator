package com.cv.generator.platform.dto;

import com.cv.generator.platform.domain.User;
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
public class JobDTO implements Serializable {

    private Long id;

    private User user;

    private String company;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;
}
