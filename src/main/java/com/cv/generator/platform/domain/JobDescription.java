package com.cv.generator.platform.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_description", schema = "cd")
public class JobDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String programmingLanguages;

    private String frameworks;

    private String tools;

    private String testing;

    private String database;

    private String interests;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    private Job job;
}
