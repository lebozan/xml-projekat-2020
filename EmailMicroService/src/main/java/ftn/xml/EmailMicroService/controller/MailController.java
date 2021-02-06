package ftn.xml.EmailMicroService.controller;

import ftn.xml.EmailMicroService.model.EmailTemplate;
import ftn.xml.EmailMicroService.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/email/send")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping(value="/textemail", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> sendEmail(@RequestBody EmailTemplate emailTemplate) {
        try {
            mailService.sendTextEmail(emailTemplate);
            return new ResponseEntity<>("Email sent!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error while sending email!", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value="/attachemail", consumes = "application/xml")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestBody EmailTemplate emailTemplate) {
        try {
            mailService.sendEmailWithAttachment(emailTemplate);
            return new ResponseEntity<>("Email sent!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error while sending email!", HttpStatus.BAD_REQUEST);
        }
    }
}
