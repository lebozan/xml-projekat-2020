package ftn.xml.EmailMicroService.service;

import ftn.xml.EmailMicroService.model.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendTextEmail(EmailTemplate emailTemplate) {

        try {

            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);


            if (emailTemplate.getSendTo().contains(",")) {
                String[] emails = emailTemplate.getSendTo().split(",");
                int receipantSize = emails.length;
                for (int i = 0; i < receipantSize; i++) {

                    helper.setTo(emails[i]);
                    helper.setSubject(emailTemplate.getSubject());
                    helper.setText(emailTemplate.getBody());
                    javaMailSender.send(msg);
                }

            } else {

                helper.setFrom("xmlservis@gmail.com", emailTemplate.getSentFrom());
                helper.setTo(emailTemplate.getSendTo());
                helper.setSubject(emailTemplate.getSubject());
                helper.setText(emailTemplate.getBody());
                javaMailSender.send(msg);
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendEmailWithAttachment(EmailTemplate mailTemplate) throws MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        try {
            helper.setTo(mailTemplate.getSendTo());
            helper.setSubject(mailTemplate.getSubject());
            // default = text/plain
            // true = text/html
            Multipart emailContent = new MimeMultipart();

            //Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("U prilogu se nalazi HTML fajl zahteva koji ste kreirali.");

            //Attachment body part.
            MimeBodyPart fileAttachment = new MimeBodyPart();
            fileAttachment.attachFile(mailTemplate.getAttachmentPath());

            //Attach body parts
            emailContent.addBodyPart(textBodyPart);
            emailContent.addBodyPart(fileAttachment);
            msg.setContent(emailContent);
            javaMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
