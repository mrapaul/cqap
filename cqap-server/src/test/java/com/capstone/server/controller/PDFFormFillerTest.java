package com.capstone.server.controller;

import com.capstone.server.controller.responses.*;
import com.itextpdf.text.pdf.*;
import org.junit.*;

import java.io.*;
import java.util.*;

public class PDFFormFillerTest
{
    @Test
    public void testForm() throws Exception
    {
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", "PR-1");
        myMappings.put("Radiologist", "Timothy Myers, M.D.");
        myMappings.put("Recipient", "Test Recipient");

        PDFFormFiller formFiller = new PDFFormFiller();
        File file = formFiller.fillForm("PRSC", myMappings, "TestPRSC.pdf");

        assert file != null;
    }

    @Test
    public void testPSFCForm() throws Exception
    {
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", "PR-1");
        myMappings.put("Radiologist", "Timothy Myers, M.D.");
        myMappings.put("Recipient", "Test Recipient");
        myMappings.put("Institution - Town, State", "Test Institution");

        PDFFormFiller formFiller = new PDFFormFiller();
        File file = formFiller.fillForm("PSFC", myMappings, "TestPSFC.pdf");

        assert file != null;
    }

    @Test
    public void testCMOForm() throws Exception
    {
        PdfReader
                reader = new PdfReader(this.getClass().getClassLoader().getResourceAsStream("templates/" + "PRSCCMO" + ".pdf"));
        PdfStamper stamper = new PdfStamper(reader, System.out);
        AcroFields form = stamper.getAcroFields();

        Map<String, AcroFields.Item> fields = form.getFields();
        System.out.println(fields);
    }
}
