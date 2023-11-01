package com.cv.generator.platform.service;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface PdfGeneratorService {

    String generateCv(Long userId) throws DocumentException, IOException;
}
