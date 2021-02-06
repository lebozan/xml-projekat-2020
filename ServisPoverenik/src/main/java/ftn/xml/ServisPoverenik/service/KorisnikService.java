package ftn.xml.ServisPoverenik.service;

import ftn.xml.ServisPoverenik.model.korisnici.Korisnici;
import ftn.xml.ServisPoverenik.model.korisnik.Korisnik;
import ftn.xml.ServisPoverenik.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository repo;

    public boolean saveUser(Korisnik korisnik) {
        return this.repo.saveUser(korisnik);
    }


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

    public Korisnici getAllUsers() {
        return repo.getAllKorisnici();
    }

}
