package ftn.xml.ServisOrganVlasti.service;

import ftn.xml.ServisOrganVlasti.repository.ObavestenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObavestenjeService {

    @Autowired
    ObavestenjeRepository obavestenjeRepository;

    public Object readObavestenje(String documentId) {

        return obavestenjeRepository.findObavestenje(documentId);
    }

    public boolean writeZahtev(String fileName) {

        return obavestenjeRepository.saveObavestenje(fileName);
    }
}
