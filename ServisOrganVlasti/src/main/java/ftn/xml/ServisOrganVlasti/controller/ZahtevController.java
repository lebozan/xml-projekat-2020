package ftn.xml.ServisOrganVlasti.controller;

import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.service.ZahtevService;
import ftn.xml.ServisOrganVlasti.util.JAXBReader;
import org.checkerframework.checker.formatter.qual.ReturnsFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Node;

@RestController
@RequestMapping(value = "/api/zahtev")
public class ZahtevController {

    @Autowired
    ZahtevService zahtevService;

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

}
