package ftn.xml.ServisOrganVlasti.controller;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import ftn.xml.ServisOrganVlasti.dto.LoginDTO;
import ftn.xml.ServisOrganVlasti.dto.UserRoleDTO;
import ftn.xml.ServisOrganVlasti.model.korisnici.Korisnici;
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
@RequestMapping(value = "/auth")
public class UserController {

    @Autowired
    private KorisnikService service;

    @Autowired
    TokenUtills tokenUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping(value = "/register", consumes = "application/xml", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> register(@RequestBody Korisnik korisnik) {
        try {
            boolean dodat = this.service.saveUser(korisnik);
            if (!dodat) {
                return new ResponseEntity<>("User already exists!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new ResponseEntity<>("ERROR", HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> login(@RequestBody Korisnik login) {
        try {

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.getKorisnickoIme(),
                    login.getLozinka());

            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpHeaders headers = new HttpHeaders();

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.loadUserByUsername(login.getKorisnickoIme());
            String authToken = tokenUtils.generateToken(details);
            System.out.println(authToken);
            headers.add("Access-Control-Expose-Headers", "token");
            headers.add("token", authToken);
            Korisnik k = this.service.login(login.getKorisnickoIme());

            return new ResponseEntity<>(k.getKorisnickoIme(),
                    headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> getUserById(@PathVariable String id) {

        try {
            Korisnik k = service.getUser(id);
            return new ResponseEntity<>(k.getIdKorisnika(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
        public ResponseEntity<Korisnici> getAllUsers() {
            Korisnici k = service.getAllUsers();

            return new ResponseEntity<>(k, HttpStatus.OK);
        }

}

