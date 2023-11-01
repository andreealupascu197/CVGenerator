package com.cv.generator.platform.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private String currentPosition;

    private LocalDate dateOfBirth;
}
