package com.cv.generator.platform.controller;

import com.cv.generator.platform.service.PdfGeneratorService;
import com.itextpdf.text.DocumentException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/generateCv")
public class PdfController {

 private PdfGeneratorService pdfGeneratorService;

    @PostMapping("/user/{id}")
    public ResponseEntity<String> generateCv(@PathVariable("id") Long userId) throws DocumentException, IOException {
        return ResponseEntity.ok().body(pdfGeneratorService.generateCv(userId));
    }
}
