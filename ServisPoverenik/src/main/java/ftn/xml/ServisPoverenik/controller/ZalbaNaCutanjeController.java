package ftn.xml.ServisPoverenik.controller;

import ftn.xml.ServisPoverenik.service.ZalbaNaCutanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/zalbaNaCutanje")
public class ZalbaNaCutanjeController {

    @Autowired
    ZalbaNaCutanjeService zalbaNaCutanjeService;

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> readXmlFile(@RequestParam String documentId) {
        try {
            Object zalbaNaCutanje = zalbaNaCutanjeService.readZalbaNaCutanje(documentId);

            return new ResponseEntity<>(zalbaNaCutanje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ResponseEntity<String> writeXmlFile(@RequestParam String fileName) {
        try {
            zalbaNaCutanjeService.writeZalbaNaCutanje(fileName);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/xml/{documentId}", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeZalbaCutanjeXml(@PathVariable String documentId, @RequestBody String xml) {
        try {
            zalbaNaCutanjeService.writeZalbaNaCutanjeXml(documentId, xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
