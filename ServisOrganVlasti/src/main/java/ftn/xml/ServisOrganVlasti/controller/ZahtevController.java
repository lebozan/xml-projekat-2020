package ftn.xml.ServisOrganVlasti.controller;

import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.service.ZahtevService;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import ftn.xml.ServisOrganVlasti.util.ZahtevXSLTransformer;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

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

@RestController
@RequestMapping(value = "/api/zahtev")
public class ZahtevController {

    @Autowired
    ZahtevService zahtevService;

    @Autowired
    ZahtevXSLTransformer zahtevXSLTransformer;

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> readXmlFile(@RequestParam String documentId) {
        try {
            Object zahtev = zahtevService.readZahtev(documentId);

            return new ResponseEntity<>(zahtev, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ResponseEntity<String> writeXmlFile(@RequestParam String fileName) {
        try {
            zahtevService.writeZahtev(fileName);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/xml/{documentId}", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeZahtevXml(@PathVariable String documentId, @RequestBody String xml) {
        try {
            zahtevService.writeZahtevXml(documentId, xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/fill", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> fillZahtev(@RequestBody String xml) {
        try {
            zahtevXSLTransformer.generateXML(xml);

            JAXBContext context = JAXBContext.newInstance(ZahtevZaPristupInformacijama.class);

            // create an instance of `Unmarshaller`
            Unmarshaller unmarshaller = context.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zahtev.xsd"));
            unmarshaller.setSchema(schema);

            // convert XML file to object
            ZahtevZaPristupInformacijama zahtev = (ZahtevZaPristupInformacijama) unmarshaller.unmarshal(new File("src/main/resources/xmlFiles/xhtml/zahtev.xml"));

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (FileNotFoundException | JAXBException | SAXException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/toHtml", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> convertXmlToXHtml(@RequestBody String xml) {
        try {
            zahtevXSLTransformer.generateHTML(xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




}
