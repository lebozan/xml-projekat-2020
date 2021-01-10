package ftn.xml.ServisOrganVlasti.controller;

import ftn.xml.ServisOrganVlasti.service.ObavestenjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/obavestenje")
public class ObavestenjeController {

    @Autowired
    ObavestenjeService obavestenjeService;

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<Object> readXmlFile(@RequestParam String documentId) {
        try {
            Object obavestenje = obavestenjeService.readObavestenje(documentId);

            return new ResponseEntity<>(obavestenje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ResponseEntity<String> writeXmlFile(@RequestParam String fileName) {
        try {
            obavestenjeService.writeZahtev(fileName);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/xml/{documentId}", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeObavestenjeXml(@PathVariable String documentId, @RequestBody String xml) {
        try {
            obavestenjeService.writeObavestenjeXml(documentId, xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
