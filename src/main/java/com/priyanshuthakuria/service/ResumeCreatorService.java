package com.priyanshuthakuria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.priyanshuthakuria.model.Candidate;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ResumeCreatorService {
    public Candidate getCandidate() {
        Candidate candidate = new Candidate();
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = Candidate.class.getResourceAsStream("/resume.json");
        try {
            candidate = mapper.readValue(inputStream, Candidate.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidate;
    }

    public ByteArrayOutputStream getPdf() {
        Candidate candidate = getCandidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        String calibri = "Calibri";
        String calibriBold = "Calibri-Bold";
        try {
            PdfWriter writer = PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();
            Font name = FontFactory.getFont(FontFactory.TIMES_BOLD, 26, BaseColor.BLACK);
            Chunk chunk = new Chunk(candidate.getName(), name);
            Paragraph paragraph = new Paragraph(chunk);
            document.add(paragraph);
            Font email = FontFactory.getFont(FontFactory.TIMES, 11, BaseColor.BLACK);
            chunk = new Chunk(candidate.getEmail(), email);
            paragraph = new Paragraph(chunk);
            document.add(paragraph);
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return byteArrayOutputStream;
    }
}
