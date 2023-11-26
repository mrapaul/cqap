package com.capstone.server.controller.responses;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.bouncycastle.jce.provider.*;
import org.docx4j.*;
import org.docx4j.convert.out.pdf.*;
import org.docx4j.convert.out.pdf.viaXSLFO.*;
import org.docx4j.openpackaging.exceptions.*;
import org.docx4j.openpackaging.packages.*;
import org.docx4j.openpackaging.parts.WordprocessingML.*;
import org.docx4j.wml.Document;

import javax.xml.bind.*;
import java.io.*;
import java.security.*;
import java.util.*;


public class UnmarshallFromTemplate
{
    public static JAXBContext context = org.docx4j.jaxb.Context.jc;

    public File unmarshall(String aTemplateFile,
                           HashMap<String, String> aMappings,
                           String aFileName,
                           String aUserPassword,
                           String aOwnerPassword) throws Docx4JException, JAXBException, IOException, DocumentException
    {
        // Open a document from the file system
        // 1. Load the Package
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
                .load(this.getClass()
                        .getClassLoader().getResourceAsStream("templates/" + aTemplateFile));

        // 2. Fetch the document part
        MainDocumentPart documentPart = wordMLPackage.getMainDocumentPart();

        Document wmlDocumentEl = documentPart.getJaxbElement();

        //xml --> string
        String xml = XmlUtils.marshaltoString(wmlDocumentEl, true);

        //valorize template
        Object obj = XmlUtils.unmarshallFromTemplate(xml, aMappings);

        //change  JaxbElement
        documentPart.setJaxbElement((Document) obj);

        // Save it
        File myFile = File.createTempFile(aFileName, ".docx");
        wordMLPackage.save(myFile);

        PdfSettings pdfSettings = new PdfSettings();

        // 3) Convert WordprocessingMLPackage to Pdf
        File myPdf = File.createTempFile(myFile.getName(), ".pdf");
        FileOutputStream out = new FileOutputStream(myPdf);
        PdfConversion converter = new Conversion(wordMLPackage);
        converter.output(out, pdfSettings);
        out.flush();
        out.close();

        File myEncryptedPdf =  File.createTempFile(myFile.getName(), "Encrypted.pdf");
        encrypt(myPdf, myEncryptedPdf, aUserPassword, aOwnerPassword);

        return myEncryptedPdf;
    }

    private void encrypt(File aInputFile,
                         File aOutputFile,
                         String aUserPassword,
                         String aOwnerPassword) throws IOException, DocumentException
    {

        int permissions = PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_COPY;
        Security.addProvider(new BouncyCastleProvider());
        PdfReader reader = new PdfReader(new FileInputStream(aInputFile));
        PdfEncryptor.encrypt(reader, new FileOutputStream(aOutputFile),
                 aUserPassword.getBytes(), aOwnerPassword.getBytes(), permissions, true);
    }
}
