package com.priyanshuthakuria.controller;

import com.priyanshuthakuria.model.Candidate;
import com.priyanshuthakuria.service.ResumeCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resumecreator")
public class Controller {
    @Autowired
    ResumeCreatorService resumeCreatorService;

    @GetMapping(value = "/resume",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Candidate getResume() {
        return resumeCreatorService.getCandidate();
    }

    @GetMapping(value = "/pdf",
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getPdf() {
        byte[] contents = resumeCreatorService.getPdf().toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        // Here you have to set the actual filename of your pdf
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }
}
