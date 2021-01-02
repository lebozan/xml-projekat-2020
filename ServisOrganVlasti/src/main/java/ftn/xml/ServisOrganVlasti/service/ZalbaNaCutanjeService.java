package ftn.xml.ServisOrganVlasti.service;

import ftn.xml.ServisOrganVlasti.repository.ZalbaNaCutanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZalbaNaCutanjeService {

    @Autowired
    ZalbaNaCutanjeRepository zalbaNaCutanjeRepository;

    public Object readZalbaNaCutanje(String documentId) {

        return zalbaNaCutanjeRepository.findZalbaNaCutanje(documentId);
    }

    public boolean writeZalbaNaCutanje(String fileName) {

        return zalbaNaCutanjeRepository.saveZalbaNaCutanje(fileName);
    }

}
