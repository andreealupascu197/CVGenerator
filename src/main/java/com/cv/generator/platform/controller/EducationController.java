package com.cv.generator.platform.controller;

import com.cv.generator.platform.dto.EducationDTO;
import com.cv.generator.platform.service.EducationService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users/education")
@AllArgsConstructor
public class EducationController {

    private EducationService educationService;


    @GetMapping
    public ResponseEntity<List<EducationDTO>> getAll() {
        return ResponseEntity.ok().body(educationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EducationDTO>> getByUserId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(educationService.getByUserId(id));

    }

    @PostMapping
    public ResponseEntity<EducationDTO> save(@RequestBody EducationDTO educationDTO) {
        return ResponseEntity.ok().body(educationService.add(educationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        educationService.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
