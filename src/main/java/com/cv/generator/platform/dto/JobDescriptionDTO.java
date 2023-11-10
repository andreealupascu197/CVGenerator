package com.cv.generator.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDescriptionDTO implements Serializable {

    private Long id;

    private String programmingLanguage;

    private String framework;

    private String tool;

    private String testing;

    private String database;

    private String interest;
}
