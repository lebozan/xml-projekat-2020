package ftn.xml.ServisOrganVlasti.service;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import ftn.xml.ServisOrganVlasti.model.korisnici.Korisnici;
import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.repository.KorisnikRDFRepository;
import ftn.xml.ServisOrganVlasti.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xmldb.api.base.XMLDBException;


@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository repo;

    @Autowired
    private KorisnikRDFRepository repoRdf;

    public boolean saveUser(Korisnik korisnik) {
        return this.repo.saveUser(korisnik);
    }


//    public void makeRDF() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, XMLDBException, JAXBException {
//        Korisnici korisnici = this.repo.getAllKorisnici();
//        this.repoRdf.saveRdf(korisnici);;
//
//    }


    public Korisnik login(String username) {
        return this.repo.login(username);
    }


    public Korisnik getLoggedUser() throws Exception {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth
                    .getPrincipal();
            return repo.login(user.getUsername());
        } catch (Exception e) {
            throw new Exception("Nije pronadjen ulogovani korisnik!");
        }

    }

    public Korisnik getUser(String id) {
        return repo.getUserById(id);
    }

}
