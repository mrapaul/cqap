package com.capstone.server.controller.responses;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.*;

public class PDFFormFiller
{
    public File fillForm(String aTemplateFile,
                         HashMap<String, String> aMappings,
                         String aFileName) throws IOException, DocumentException
    {
        File myPdf = File.createTempFile(aFileName, "pdf");
        PdfReader reader = new PdfReader(getClass().getClassLoader().getResourceAsStream("templates/" + aTemplateFile));
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(myPdf));
        AcroFields form = stamper.getAcroFields();
        for (Map.Entry<String, String> myEntry : aMappings.entrySet())
        {
            form.setField(myEntry.getKey(), myEntry.getValue());
        }
        stamper.close();
        reader.close();

        return myPdf;
    }
}
