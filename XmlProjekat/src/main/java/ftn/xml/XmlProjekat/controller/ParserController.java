package ftn.xml.XmlProjekat.controller;

import ftn.xml.XmlProjekat.DTO.PathDTO;
import ftn.xml.XmlProjekat.parser.DOMParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/parser")
public class ParserController {



    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<String> readXmlFile(@RequestBody PathDTO pathDTO) {
        try {
            DOMParser.ReadXmlJaxb(pathDTO.getFilePath());

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public ResponseEntity<String> writeXmlFile() {
        try {
            DOMParser.WriteXmlJaxb();

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
