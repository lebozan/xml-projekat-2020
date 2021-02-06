package ftn.xml.ServisPoverenik.controller;

import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbaNaOdluku;
import ftn.xml.ServisPoverenik.model.zalbanaodluku.ZalbeNaOdluku;
import ftn.xml.ServisPoverenik.service.ZalbaNaOdlukuService;

import java.io.File;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ftn.xml.ServisPoverenik.util.ZalbaNaOdlukuXSLTransformer;


@RestController
@RequestMapping(value = "/api/zalbaNaOdluku")
public class ZalbaNaOdlukuController {

    @Autowired
    ZalbaNaOdlukuService zalbaNaOdlukuService;

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> readXmlFile(@RequestParam String documentId) {
        try {
            Object zalbaNaOdluku = zalbaNaOdlukuService.readZalbaNaOdluku(documentId);

            return new ResponseEntity<>(zalbaNaOdluku, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ResponseEntity<String> writeXmlFile(@RequestParam String fileName) {
        try {
            zalbaNaOdlukuService.writeZalbaNaOdluku(fileName);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/createZalbaOdluka", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeZalbaOdlukaXml(@RequestBody String xml) {
        try {
            ZalbaNaOdlukuXSLTransformer.generateXML(xml);

            JAXBContext context = JAXBContext.newInstance(ZalbaNaOdluku.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File("../xml-documents/zalbanaodluku-schema.xsd"));
            unmarshaller.setSchema(schema);
            ZalbaNaOdluku zalbaOdluka = (ZalbaNaOdluku) unmarshaller.unmarshal(new File("../xml-documents/zalbanaodluku.xml"));
            zalbaNaOdlukuService.writeZalbaNaOdluku(zalbaOdluka);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
