package com.cv.generator.platform.controller;


import com.cv.generator.platform.dto.JobDTO;
import com.cv.generator.platform.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/job")
@AllArgsConstructor
public class JobController {

    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDTO>> getAll() {
        return ResponseEntity.ok().body(jobService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<JobDTO>> getByUserId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(jobService.getAllByUserId(id));
    }

    @PostMapping
    public ResponseEntity<JobDTO> save(@RequestBody JobDTO jobDTO) {
        return ResponseEntity.ok().body(jobService.add(jobDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        jobService.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
