package com.cv.generator.platform.dto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDescriptionDTO implements Serializable {

    private Long id;

    private String programmingLanguages;

    private String frameworks;

    private String tools;

    private String testing;

    private String database;

    private String interests;
}
