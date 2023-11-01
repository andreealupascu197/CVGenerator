package com.cv.generator.platform.controller;

import com.cv.generator.platform.dto.JobDescriptionDTO;
import com.cv.generator.platform.service.JobDescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/users/job/description")
@RestController
public class JobDescriptionController {

    private JobDescriptionService jobDescriptionService;

    @GetMapping
    public ResponseEntity<List<JobDescriptionDTO>> getAll() {
        return ResponseEntity.ok().body(jobDescriptionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDescriptionDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(jobDescriptionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<JobDescriptionDTO> save(@RequestBody JobDescriptionDTO jobDescriptionDTO) {
        return ResponseEntity.ok().body(jobDescriptionService.add(jobDescriptionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        jobDescriptionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
