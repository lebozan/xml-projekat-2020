package ftn.xml.EmailMicroService.controller;

import ftn.xml.EmailMicroService.model.MailTemplate;
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

    @PostMapping(value="/textemail", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> sendEmail(@RequestBody MailTemplate emailTemplate) {
        try {
            mailService.sendTextEmail(emailTemplate);
            return new ResponseEntity<>("Email sent!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error while sending email!", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value="/attachemail", consumes = "multipart/form-data")
    public ResponseEntity<String> sendEmailWithAttachment(@RequestBody MailTemplate emailTemplate, @RequestPart(value = "file") MultipartFile file) {
        try {
            mailService.sendEmailWithAttachment(emailTemplate, file);
            return new ResponseEntity<>("Email sent!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error while sending email!", HttpStatus.BAD_REQUEST);
        }
    }
}
