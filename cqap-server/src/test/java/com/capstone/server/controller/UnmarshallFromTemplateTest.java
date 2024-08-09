package com.capstone.server.controller;

import com.capstone.server.controller.responses.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.parser.*;
import org.junit.*;

import java.io.*;
import java.util.*;

import static org.fest.assertions.Assertions.*;

//@Ignore
public class UnmarshallFromTemplateTest
{
    @Test
    public void unmarshall() throws Exception
    {
        HashMap<String, String> myMappings = new HashMap<>();
        myMappings.put("TicketNumber", "PR-1");
        myMappings.put("Date", "2422-23-12");
        myMappings.put("Recipient", "Test Recipient");

        UnmarshallFromTemplate myUnmarshallFromTemplate = new UnmarshallFromTemplate();
        File myFile = myUnmarshallFromTemplate.unmarshall("ERP_Category_1_Response_Letter.docx",
                myMappings,
                "test");

        assertThat(myFile).isNotNull();
    }

    @Test
    public void testPDF() throws Exception
    {
        String myTemplateName = "file.pdf";
        InputStream myInputStream = getClass().getClassLoader().getResourceAsStream(myTemplateName);
        PdfReader reader = new PdfReader(myInputStream);

        System.out.println("This PDF has "+reader.getNumberOfPages()+" pages.");
        StringBuilder myReportBuilder = new StringBuilder();
        for (int i = 1; i < reader.getNumberOfPages()+1; i++)
        {
            myReportBuilder.append(PdfTextExtractor.getTextFromPage(reader, i)).append("\n\n");
        }
        System.out.println("Page Content:\n\n"+myReportBuilder.toString()+"\n\n");
        System.out.println("Is this document tampered: "+reader.isTampered());
        System.out.println("Is this document encrypted: "+reader.isEncrypted());

    }
}
