package ftn.xml.ServisOrganVlasti.service;

import com.github.krukow.clj_lang.Obj;
import ftn.xml.ServisOrganVlasti.dto.PathDTO;
import ftn.xml.ServisOrganVlasti.model.zahtev.ZahtevZaPristupInformacijama;
import ftn.xml.ServisOrganVlasti.model.zahtevi.Zahtevi;
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


    public void writeZahtevXml(ZahtevZaPristupInformacijama zahtev) throws Exception {
        zahtevRepository.saveZahtevXml(zahtev);
    }

    public Object getAllZahtevi() {
        return zahtevRepository.getAllZahtevi();
    }

}
