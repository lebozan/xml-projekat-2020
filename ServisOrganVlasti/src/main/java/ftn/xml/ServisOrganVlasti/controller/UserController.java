package ftn.xml.ServisOrganVlasti.controller;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ftn.xml.ServisOrganVlasti.dto.LoginDTO;
import ftn.xml.ServisOrganVlasti.dto.UserRoleDTO;
import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.security.TokenUtills;
import ftn.xml.ServisOrganVlasti.service.KorisnikService;
import org.apache.xerces.parsers.DOMParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;


@RestController
public class UserController {

    @Autowired
    private KorisnikService service;

    @Autowired
    TokenUtills tokenUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/addUser", consumes = "application/xml", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> test(@RequestBody Korisnik korisnik) {
        try {
            this.service.saveUser(korisnik);

            return new ResponseEntity<>(korisnik.getKorisnickoIme(), HttpStatus.OK);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | XMLDBException | JAXBException | SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRoleDTO> login(@RequestBody LoginDTO login) {
        try {

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.getUsername(),
                    login.getPassword());
            System.out.println(token);
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpHeaders headers = new HttpHeaders();

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.loadUserByUsername(login.getUsername());
            String authToken = tokenUtils.generateToken(details);
            System.out.println(authToken);
            headers.add("Access-Control-Expose-Headers", "X-Auth-Token");
            headers.add("X-Auth-Token", authToken);
            Korisnik k = this.service.login(login);

            return new ResponseEntity<UserRoleDTO>(new UserRoleDTO(login.getUsername(), k.getUloga()),
                    headers, HttpStatus.OK);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException | XMLDBException
                | JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<UserRoleDTO>(new UserRoleDTO(e.getMessage(), e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/postTest", produces = "application/xml", consumes = "application/xml")
    public ResponseEntity<Korisnik> postUser(@RequestBody Korisnik testKorisnik) {
        testKorisnik.setKorisnickoIme("newusername");

        System.out.println("Getting user");

        return new ResponseEntity<>(testKorisnik, HttpStatus.OK);
    }

    @GetMapping(value = "/proba", produces = "application/xml")
    public void Metapodaci() throws Exception {

        this.service.metapodaci();

    }
//
//    @GetMapping(value = "/test", produces = "application/xml")
//    public ResponseEntity<Korisnik> getUser() throws JAXBException {
//        DOMParser parser = new DOMParser();
////		System.out.println("CURRENTLY IN " + System.getProperty("user.dir"));
////		Document doc = parser.buildDocument("src/main/resources/primeri/korisnik.xml");
//        JAXBContext context = JAXBContext.newInstance(Korisnik.class);
////		Unmarshaller unmarshaller = context.createUnmarshaller();
////		Korisnik korisnik = (Korisnik) unmarshaller.unmarshal(doc);
//
//        Korisnik testKorisnik = new Korisnik();
//
//        testKorisnik.setAktivan(true);
//        testKorisnik.setKorisnickoIme("admin");
//        testKorisnik.setLozinka("admin");
//        testKorisnik.setIdKorisnika("0001");
//        testKorisnik.setIme("Pera");
//        testKorisnik.setPrezime("Peric");
//        testKorisnik.setJmbg("1234567890123");
//        testKorisnik.setTipKorisnika("pacijent");
//
//        Document doc = parser.createNewDocument();
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        marshaller.marshal(testKorisnik, doc);
//        parser.printNode(doc);
//
//        return new ResponseEntity<>(testKorisnik, HttpStatus.OK);
//    }
}

