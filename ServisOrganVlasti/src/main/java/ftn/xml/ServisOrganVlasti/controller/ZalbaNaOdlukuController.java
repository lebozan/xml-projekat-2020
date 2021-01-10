package ftn.xml.ServisOrganVlasti.controller;


import ftn.xml.ServisOrganVlasti.service.ZalbaNaOdlukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/zalba-na-odluku")
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

    @RequestMapping(value = "/xml/{documentId}", method = RequestMethod.POST, consumes = "application/xml")
    public ResponseEntity<String> writeZalbaOdlukaXml(@PathVariable String documentId, @RequestBody String xml) {
        try {
            zalbaNaOdlukuService.writeZalbaNaOdlukuXml(documentId, xml);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
