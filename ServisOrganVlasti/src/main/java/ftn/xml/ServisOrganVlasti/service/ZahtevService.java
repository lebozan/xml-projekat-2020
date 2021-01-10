package ftn.xml.ServisOrganVlasti.service;

import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

@Service
public class ZahtevService {

    @Autowired
    ZahtevRepository zahtevRepository;

    public Object readZahtev(String documentId) {

        return zahtevRepository.findZahtev(documentId);
    }

    public boolean writeZahtev(String fileName) {

        return zahtevRepository.saveZahtev(fileName);
    }

    public void writeZahtevXml(String documentId, String xml) throws Exception {
        zahtevRepository.saveZahtevXml(documentId, xml);
    }

}
