package ftn.xml.ServisOrganVlasti.controller;

import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.email.EmailTemplate;
import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.model.zahtevi.Zahtevi;
import ftn.xml.ServisOrganVlasti.service.ZahtevService;
import ftn.xml.ServisOrganVlasti.soap.zahtev.GetZahtevResponse;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import ftn.xml.ServisOrganVlasti.util.ZahtevXSLTransformer;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import reactor.core.publisher.Mono;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/zahtev")
public class ZahtevController {

    @Autowired
    ZahtevService zahtevService;

    @Autowired
    ZahtevXSLTransformer zahtevXSLTransformer;


    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> findZahtevById(@PathVariable String id) {
        try {
            Object zahtev = zahtevService.readZahtev(id);

            return new ResponseEntity<>(zahtev, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/createZahtev", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeZahtevXml(@RequestBody String xml) {
        try {
            zahtevXSLTransformer.generateXML(xml);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
            unmarshaller.setSchema(schema);
            ZahtevZaPristupInformacijama zahtev = (ZahtevZaPristupInformacijama) unmarshaller.unmarshal(new File("src/main/resources/xmlFiles/xhtml/zahtev.xml"));
            zahtev.setId(UUID.randomUUID().toString());
            zahtevService.writeZahtevXml(zahtev);

            sendEmail();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/fill", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> fillZahtev(@RequestBody String xml) {
        try {
            zahtevXSLTransformer.generateXML(xml);

            return new ResponseEntity<>(Files.readString(Path.of("src/main/resources/xmlFiles/xhtml/zahtev.xml")), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/toHtml", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> convertXmlToXHtml(@RequestBody String xml) {
        try {
            zahtevXSLTransformer.generateHTML(xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllZahtevi() throws IOException {
        Object z = zahtevService.getAllZahtevi();
        if (z != null) {
            return new ResponseEntity<>(z, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    private void sendEmail() {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String korisnik = "ggwp012@gmail.com";
        EmailTemplate emailTemplate = new EmailTemplate();
        emailTemplate.setAttachmentPath("D:\\Users\\Hp Zbook 15\\Desktop\\xml-projekat-2020\\ServisOrganVlasti\\src\\main\\resources\\xmlFiles\\xhtml\\zahtev.html");
        emailTemplate.setBody("HTML kreiranog zahteva.");
        emailTemplate.setSentFrom("Servis organa vlasti");
        emailTemplate.setSubject("Uspesno kreiran zahtev");
        emailTemplate.setSendTo(korisnik);


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<EmailTemplate> entity = new HttpEntity<>(emailTemplate);


        restTemplate.postForEntity("http://localhost:6969/email/send/attachemail", entity, String.class);
    }

}
