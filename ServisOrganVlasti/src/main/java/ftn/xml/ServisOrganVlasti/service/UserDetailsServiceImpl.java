package ftn.xml.ServisOrganVlasti.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;


import ftn.xml.ServisOrganVlasti.model.korisnik.Korisnik;
import ftn.xml.ServisOrganVlasti.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.xmldb.api.base.XMLDBException;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private KorisnikRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Korisnik user = null;
        try {
            user = userRepository.login(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        } else {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getTipKorisnika());
            ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(grantedAuthority);

            return user;
        }

    }
}