package com.capstone.server.controller.responses;


import org.docx4j.*;
import org.docx4j.convert.out.pdf.*;
import org.docx4j.convert.out.pdf.viaXSLFO.*;
import org.docx4j.openpackaging.exceptions.*;
import org.docx4j.openpackaging.packages.*;
import org.docx4j.openpackaging.parts.WordprocessingML.*;
import org.docx4j.wml.*;

import javax.xml.bind.*;
import java.io.*;
import java.util.*;


public class UnmarshallFromTemplate
{
    public static JAXBContext context = org.docx4j.jaxb.Context.jc;

    public File unmarshall(String aTemplateFile,
                           HashMap<String, String> aMappings,
                           String aFileName) throws Docx4JException, JAXBException, IOException
    {
        // Open a document from the file system
        // 1. Load the Package
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                .load(this.getClass()
                        .getClassLoader().getResourceAsStream("templates/" + aTemplateFile));

        // 2. Fetch the document part
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        org.docx4j.wml.Document wmlDocumentEl = documentPart.getJaxbElement();

        //xml --> string
        String xml = XmlUtils.marshaltoString(wmlDocumentEl, true);

        //valorize template
        Object obj = XmlUtils.unmarshallFromTemplate(xml, aMappings);

        //change  JaxbElement
        documentPart.setJaxbElement((Document) obj);

        // Save it
        File myFile = new File(aFileName + ".docx");
        wordMLPackage.save(myFile);

        PdfSettings pdfSettings = new PdfSettings();

        // 3) Convert WordprocessingMLPackage to Pdf
        File myPdf = new File(myFile.getName() + ".pdf");
        FileOutputStream out = new FileOutputStream(myPdf);
        PdfConversion converter = new org.docx4j.convert.out.pdf.viaXSLFO.Conversion(wordMLPackage);
        converter.output(out, pdfSettings);
        out.flush();

        return myPdf;
    }
}
