package ftn.xml.ServisOrganVlasti.controller;

import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.model.zahtevi.Zahtevi;
import ftn.xml.ServisOrganVlasti.service.ZahtevService;
import ftn.xml.ServisOrganVlasti.soap.zahtev.GetZahtevResponse;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import ftn.xml.ServisOrganVlasti.util.ZahtevXSLTransformer;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    UUID uuid = UUID.randomUUID();

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> readXmlFile(@RequestParam String documentId) {
        try {
            Object zahtev = zahtevService.readZahtev(documentId);

            return new ResponseEntity<>(zahtev, HttpStatus.OK);
        } catch (Exception e) {
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

            zahtevService.writeZahtevXml(zahtev);

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


}
