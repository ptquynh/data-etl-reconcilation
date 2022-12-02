package com.etl.common.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.etl.common.TestBase;
import com.etl.common.Utils;


public class SendEmail {

	public static void main(String[] args) {

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.googlemail.com";
        String email_from=args[0];
        String email_pass=args[1];
        String email_to=args[2];
        
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", email_from);
        props.put("mail.smtp.password",email_pass);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        
       // Session session = Session.getDefaultInstance(props);

        // Get the Session object.// and pass 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(email_from,email_pass);

            }

        });
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(email_from));

           
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_to));

            // Set Subject: header field
            message.setSubject("[QA][Data] Test Report " +Utils.getCurrentDate("dd/MM/yyyy hh:mm:ss"));

            
            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart htmlPart = new MimeBodyPart();
            

            try {
            	
            	String pathHtml = Utils.getAbsolutePath(TestBase.TEST_REPORT_PATH);

                File f =new File(pathHtml);
                attachmentPart.attachFile(f);
                
                StringBuilder contentBuilder = new StringBuilder();
                try {
                    BufferedReader in = new BufferedReader(new FileReader(pathHtml));
                    String str;
                    while ((str = in.readLine()) != null) {
                        contentBuilder.append(str);
                    }
                    in.close();
                } catch (IOException e) {
                }
                String contentHtml = contentBuilder.toString();
                multipart.addBodyPart(htmlPart);
                htmlPart.setContent(contentHtml, "text/html; charset=utf-8");
                message.saveChanges();
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }

            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

	}

}
