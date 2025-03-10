package com.TextSnap;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@RestController
public class ConvertImageToText {

	@PostMapping("/file/upload")
	public ResponseEntity<String> convertImageToText(@RequestParam("file") MultipartFile file) throws IOException, TesseractException {
       
		 if (file.isEmpty()) {
		        return ResponseEntity.badRequest().body("File is empty. Please upload a valid image.");
		    }
		
		File tempFile = File.createTempFile("uploaded_", ".png");
        file.transferTo(tempFile);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("tessdata");
        tesseract.setLanguage("eng");
        tesseract.setVariable("user_defined_dpi", "300");

        String extractTexted=tesseract.doOCR(tempFile);
        tempFile.delete();
        
		return ResponseEntity.ok(extractTexted);
	}
}
