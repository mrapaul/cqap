package com.cqap.mail;

import org.slf4j.*;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SendMail.class);
    private static final String USERNAME = "qa@capstoneradiology.com";
    private static final String PASSWORD = "Q@C@pst0n3";

    public static void sendMail(String aTo,
                                String aSubject,
                                String aBody,
                                String aAttachmentName,
                                String aAttachmentLocation)
    {
        Properties myProperties = new Properties();
        myProperties.put("mail.smtp.auth", "true");
        myProperties.put("mail.smtp.starttls.enable", "true");
        myProperties.put("mail.smtp.host", "smtp.gmail.com");
        myProperties.put("mail.smtp.port", "587");

        Session mySession = Session.getInstance(myProperties, new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try
        {

            Message myMessage = new MimeMessage(mySession);
            Multipart myMultipart = new MimeMultipart();
            myMessage.setFrom(new InternetAddress(USERNAME));
            myMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(aTo));
            myMessage.setSubject(aSubject);
            myMessage.setText(aBody);
            MimeBodyPart myBody = new MimeBodyPart();
            myBody.setText(aBody);
            myMultipart.addBodyPart(myBody);
            MimeBodyPart myAttachment = new MimeBodyPart();
            DataSource myDataSource = new FileDataSource(aAttachmentLocation);
            myAttachment.setDataHandler(new DataHandler(myDataSource));
            myAttachment.setFileName(aAttachmentName);
            myMultipart.addBodyPart(myAttachment);
            myMessage.setContent(myMultipart);

            Transport.send(myMessage);
        }
        catch (MessagingException aException)
        {
            LOGGER.error("Error sending mail to {}", aTo, aException);
        }
    }
}
