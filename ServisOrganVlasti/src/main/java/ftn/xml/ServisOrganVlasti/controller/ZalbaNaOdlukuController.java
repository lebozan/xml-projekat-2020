package ftn.xml.ServisOrganVlasti.controller;


import ftn.xml.ServisOrganVlasti.service.ZalbaNaOdlukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}
