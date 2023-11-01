package com.cv.generator.platform.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job", schema = "cd")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private User user;

    private String company;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_description_id", referencedColumnName = "id")
    private JobDescription jobDescription;


}
